package com.lqm.controller.portal;

import com.lqm.common.Const;
import com.lqm.common.ResponseCode;
import com.lqm.common.ServerResponse;
import com.lqm.pojo.User;
import com.lqm.service.IUserService;
import com.lqm.util.JsonUtil;
import com.lqm.util.RedisShardedPoolUtil;
import com.lqm.util.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户相关
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value = "login.do")
    @ResponseBody
    public ServerResponse<User> login(String username,
                                      String password){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            //1,写token到redis
            String tokenValue = TokenUtil.writeLoginTokenToRedis(Const.TOKEN_PREFIX+username);
            //2,写用户信息到redis
            RedisShardedPoolUtil.setEx(tokenValue, JsonUtil.obj2String(response.getData()), 60*60*12);
            return ServerResponse.createBySuccess(tokenValue,response.getData());
        }else {
            return ServerResponse.createByErrorMessage("登陆失败");
        }


    }

    @RequestMapping(value = "logout.do")
    @ResponseBody
    public ServerResponse<String> logout(HttpServletRequest httpServletRequest){
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        RedisShardedPoolUtil.del(loginToken);
        return ServerResponse.createBySuccessMessage("注销登录成功");
    }

    @RequestMapping(value = "register.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user){
        return iUserService.register(user);
    }


    @RequestMapping(value = "check_valid.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type){
        return iUserService.checkValid(str,type);
    }


    @RequestMapping(value = "get_user_info.do")
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpServletRequest httpServletRequest){

        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User user = JsonUtil.string2Obj(userJsonStr,User.class);
        return ServerResponse.createBySuccess(user);
    }


    @RequestMapping(value = "forget_get_question.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String username){
        return iUserService.selectQuestion(username);
    }


    @RequestMapping(value = "forget_check_answer.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetCheckAnswer(String username, String question, String answer){
        return iUserService.checkAnswer(username,question,answer);
    }


    @RequestMapping(value = "forget_reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetRestPassword(String username, String passwordNew, String forgetToken){
        return iUserService.forgetResetPassword(username,passwordNew,forgetToken);
    }


    /**
     * 登录状态重置密码
     * @param passwordOld
     * @param passwordNew
     * @return
     */
    @RequestMapping(value = "reset_password.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(HttpServletRequest httpServletRequest,
                                                String passwordOld,
                                                String passwordNew){

        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User user = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken),User.class);

        return iUserService.resetPassword(passwordOld,passwordNew,user);
    }


    @RequestMapping(value = "update_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpServletRequest httpServletRequest,User user){
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User currentUser = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken),User.class);
        if(currentUser == null){
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if(response.isSuccess()){
            response.getData().setUsername(currentUser.getUsername());
            RedisShardedPoolUtil.setEx(loginToken,JsonUtil.obj2String(response.getData()),TokenUtil.TOKEN_EX_TIME);

        }
        return response;
    }

    @RequestMapping(value = "get_information.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpServletRequest httpServletRequest){
        String loginToken = TokenUtil.readLoginTokenByHeader(httpServletRequest);
        User user = JsonUtil.string2Obj(RedisShardedPoolUtil.get(loginToken),User.class);
        return iUserService.getInformation(user.getId());
    }

}
