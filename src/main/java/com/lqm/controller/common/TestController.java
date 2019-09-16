package com.lqm.controller.common;

import com.github.pagehelper.PageInfo;
import com.lqm.common.Const;
import com.lqm.common.ResponseCode;
import com.lqm.common.ServerResponse;
import com.lqm.pojo.TestPojo;
import com.lqm.pojo.User;
import com.lqm.service.ITestService;
import com.lqm.service.IUserService;
import com.lqm.service.RedissonService;
import com.lqm.util.CookieUtil;
import com.lqm.util.JsonUtil;
import com.lqm.util.RedisShardedPoolUtil;
import com.lqm.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * 测试用
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @Autowired
    ITestService iTestService;

    @Autowired
    RedissonService redissonService;

    @Autowired
    IUserService iUserService;



    /**
     * http://localhost:8080/test/testLogBack
     * 测试集成logback
     */
    @RequestMapping("testLogBack")
    @ResponseBody
    public TestPojo test(){
        log.debug("记录debug日志");
        log.info("访问了index方法");
        log.error("记录error错误日志");

        TestPojo testPojo = new TestPojo();
        testPojo.setId(666);

        log.info("testPojoJson:{}",testPojo);

        log.info("end");
        return testPojo;
    }

    /**
     * 测试数据库操作
     * http://localhost:8080/test/testSqlPager?pageNum=1&pageSize=5
     */
    @RequestMapping(value = "testSqlPager", method = RequestMethod.GET )
    public ServerResponse<PageInfo> testSql(
            @RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize",defaultValue = "2") int pageSize){
        return iTestService.testPageHelp(pageNum,pageSize);
    }



    @RequestMapping(value = "testToken", method = RequestMethod.GET )
    public ServerResponse<User> testSql(
            HttpServletRequest httpServletRequest){
        String loginToken = CookieUtil.readLoginTokenByHeader(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User user = JsonUtil.string2Obj(userJsonStr,User.class);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),ResponseCode.NEED_LOGIN.getDesc());
        }
        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "testLogin",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<User> login(String username,
                                      String password){
        ServerResponse<User> response = iUserService.login(username,password);
        if(response.isSuccess()){
            //1,写token到redis
            String tokenValue = TokenUtil.writeLoginTokenToRedis(Const.TOKEN_PREFIX+username);
            //2,写用户信息到redis
            RedisShardedPoolUtil.setEx(tokenValue, JsonUtil.obj2String(response.getData()), 60*60*12);

            return ServerResponse.createBySuccessMessage(tokenValue);
        }else {
            return ServerResponse.createByErrorMessage("登陆失败");
        }
    }

    @RequestMapping(value = "testGetUserData", method = RequestMethod.GET )
    public ServerResponse<User> testGetUserData(
            HttpServletRequest httpServletRequest){

       String loginToken =  TokenUtil.readLoginTokenByHeader(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("用户未登录,无法获取当前用户的信息");
        }
        String userJsonStr = RedisShardedPoolUtil.get(loginToken);
        User user = JsonUtil.string2Obj(userJsonStr,User.class);
        if(user ==null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"登陆token过期,请重新登陆");
        }
        return ServerResponse.createBySuccess(user);
    }

    @RequestMapping(value = "testLogou", method = RequestMethod.GET )
    public ServerResponse<String> testLogou(
            String username,
            HttpServletRequest httpServletRequest){

        String loginToken =  TokenUtil.readLoginTokenByHeader(httpServletRequest);
        if(StringUtils.isEmpty(loginToken)){
            return ServerResponse.createByErrorMessage("token为空");
        }
        RedisShardedPoolUtil.del(Const.TOKEN_PREFIX+username);
        RedisShardedPoolUtil.del(loginToken);

        return ServerResponse.createBySuccessMessage("注销登录成功");
    }



    /**
     * 测试异常统一处理
     */
    @RequestMapping("testError")
    public String testError(int num){
        log.error("数据"+10/num);
        return "请求完成";
    }


    /**
     * 测试redis
     * **
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     * unless 表示条件表达式成立的话不放入缓存
     * @CachePut 应用到写数据的方法上，如新增/修改的方法，调用方法时会自动把相应的数据放入缓存
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应key的数据
     */
    @RequestMapping("testRedis")
    public ServerResponse<List<User>> testRedis(){
        return iTestService.testRedisCache();
    }


    /**
     * 测试Redisson 分布式锁
     * @param recordId
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public void test(String recordId) {

        RLock lock = redissonService.getRLock(recordId);
        try {
            boolean bs = lock.tryLock(0, 50, TimeUnit.SECONDS);
            if (bs) {
                // 业务代码
                log.info("Redisson获取到分布式锁,进入业务代码: " + recordId);
                lock.unlock();
            } else {
                Thread.sleep(300);
            }
        } catch (Exception e) {
            log.error("", e);
            lock.unlock();
        }
    }


}
