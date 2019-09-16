package com.lqm.config.interceptor;

import com.lqm.common.Const;
import com.lqm.common.LoginPublicUri;
import com.lqm.common.ResponseCode;
import com.lqm.common.ServerResponse;
import com.lqm.pojo.User;
import com.lqm.util.JsonUtil;
import com.lqm.util.RedisShardedPoolUtil;
import com.lqm.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * controller执行之前
     * 返回false.即不会调用controller里的方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");

        //用于判断是否需要做登录校验
        boolean isNeedLogin = true;

        //请求存在于公开地址，则不需要做登录校验
        for(String uri : LoginPublicUri.LIST){
            if(request.getRequestURI().startsWith(uri)){
                isNeedLogin = false;
                break;
            }
        }

        //TODO 把登陆校验改为token模式
        if(isNeedLogin){

            String loginToken = request.getHeader("login_token");
            if(StringUtils.isEmpty(loginToken)){
                response.reset();//geelynote 这里要添加reset，否则报异常 getWriter() has already been called for this response.
                response.setCharacterEncoding("UTF-8");//geelynote 这里要设置编码，否则会乱码
                response.setContentType("application/json;charset=UTF-8");//geelynote 这里要设置返回值的类型，因为全部是json接口。

                PrintWriter out = response.getWriter();
                out.print(JsonUtil.obj2String(ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"token为空或无效")));

                out.flush();
                out.close();

                return false;
            }
            String userJsonStr = RedisShardedPoolUtil.get(loginToken);
            User user = JsonUtil.string2Obj(userJsonStr,User.class);

            if(null == user){

                response.reset();//geelynote 这里要添加reset，否则报异常 getWriter() has already been called for this response.
                response.setCharacterEncoding("UTF-8");//geelynote 这里要设置编码，否则会乱码
                response.setContentType("application/json;charset=UTF-8");//geelynote 这里要设置返回值的类型，因为全部是json接口。

                PrintWriter out = response.getWriter();
                out.print(JsonUtil.obj2String(ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"拦截器拦截,用户未登录或登陆过期，请登陆")));

                out.flush();
                out.close();//geelynote 这里要关闭
                return false;
            }
        }

        return true;
    }

    /**
     * controller处理之后
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    /**
     * 所有处理之后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
