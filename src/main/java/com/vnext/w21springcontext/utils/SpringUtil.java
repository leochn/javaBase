package com.vnext.w21springcontext.utils;

import com.vnext.w21springcontext.annotation.RpcService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author leo
 * @version 2018/6/13 7:13
 * @since 1.0.0
 */
public class SpringUtil {

    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
        }
        try {
            Map<String, Object> serviceBeanMap = SpringUtil.applicationContext.getBeansWithAnnotation(RpcService.class);
            for (Object serviceBean : serviceBeanMap.values()) {
                // 获取自定义注解上的value
                String value = serviceBean.getClass().getAnnotation(RpcService.class).value();
                System.out.println("注解上的value = " + value);

                Method method = serviceBean.getClass().getMethod("hello", new Class[]{String.class});
                Object result = method.invoke(serviceBean, "tone");
                System.out.println("result = " + result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        //查询所有预警任务,开启的预警任务自动开启
//        RiskWarningTaskService riskWarningTaskServiceStatic=applicationContext.getBean(RiskWarningTaskService.class);
//        List<EarlyWarningTask> earlyWarningTask = riskWarningTaskServiceStatic.findEarlyWarningTaskAll();
//        for (EarlyWarningTask warningTask : earlyWarningTask) {
//            //如果任务是打开的,可就开启任务
//            if("1".equals(warningTask.getStat())){
//                riskWarningTaskServiceStatic.editState("1",warningTask.getId().toString(),warningTask.getTitle());
//                riskWarningTaskServiceStatic.editState("0",warningTask.getId().toString(),warningTask.getTitle());
//            }
//        }
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);

    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }
}