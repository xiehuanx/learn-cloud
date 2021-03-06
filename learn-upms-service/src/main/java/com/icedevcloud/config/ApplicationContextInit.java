package com.icedevcloud.config;

import com.icedevcloud.common.core.spring.SpringHelper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 初始化 SpringHelper ApplicationContext
 *
 * @author XiaoBingBy
 * @since 2020-04-17
 */
@Component
public class ApplicationContextInit implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringHelper.setApplicationContext(applicationContext);
    }

}
