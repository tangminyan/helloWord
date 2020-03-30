package baobei.cute.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by tangminyan on 2019/5/27.
 */
public class SpringBeanFactoryUtils implements ApplicationContextAware {
    private static ApplicationContext appCtx;
    public static ApplicationContext getApplicationContext() {
        return appCtx;
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }
    public static Object getBean(String beanName) {
        return appCtx.getBean(beanName);
    }
}
