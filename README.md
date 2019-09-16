# store
微商城后端,springboot


记录：
    war包 javax/el/ELManager错误解决：
    错误原因是因为tomcat7中的el-api2.2 版本太低导致
    方法一:直接下载一个el-api3.x.jar替换tomcat中的el-api2.2.jar
    方法二,直接下载tomcat8安装解决问题



portal模块的controller类，不需要登录拦截的uri配置在LoginPublicUri类里面

backend模块的controller类，登录与用户管理员权限拦截在AuthorityInterceptor里面


过滤器匹配：
    	//匹配com.lqm.controller包下的所有方法
    //	@Pointcut("execution(public * com.lqm.controller.*.*(..))")
    	//匹配com.lqm.controller包及其子包下的所有方法
    	@Pointcut("execution(* com.lqm.controller..*.*(..))")


jackson config不生效记录：之前AuthorityInterceptorConfig 我继承WebMvcConfigurationSupport，
然后jackson config  的就失效了，神奇，把之前AuthorityInterceptorConfig改
为 implements WebMvcConfigurer  就可以了


orderControler报错，  Caused by: java.lang.NoClassDefFoundError: com/alipay/api/AlipayApiException  
解决：https://blog.csdn.net/huanjia_h/article/details/72026757   war 加入alipay相关jar包


启动报错：    Error creating bean with name 'gsonBuilder'
更换gson版本为2.6.2 后解决


