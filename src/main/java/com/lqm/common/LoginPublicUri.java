package com.lqm.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 公开地址，在此类声明过的公开地址均不会被登陆拦截
 */

public class LoginPublicUri {

    public static final List<String> LIST = new ArrayList<>();
    
    static{
        LIST.add("/order/alipay_callback.do");
        LIST.add("/user/login.do");
        LIST.add("/user/logout.do");
        LIST.add("/user/register.do");
        LIST.add("/user/forget_get_question.do");
        LIST.add("/user/forget_check_answer.do");
        LIST.add("/user/forget_reset_password.do");

    }
}
