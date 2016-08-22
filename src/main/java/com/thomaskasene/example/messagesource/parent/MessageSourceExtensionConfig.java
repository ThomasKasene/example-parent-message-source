package com.thomaskasene.example.messagesource.parent;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.HierarchicalMessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Thomas Kåsene
 */
@Configuration
@EnableAutoConfiguration
class MessageSourceExtensionConfig {

    @Bean
    BeanPostProcessor messageSourceCustomExtender() {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                return bean;
            }

            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof HierarchicalMessageSource && beanName.equals("messageSource")) {
                    ResourceBundleMessageSource parent = new ResourceBundleMessageSource();
                    parent.setBasename("custom");

                    ((HierarchicalMessageSource) bean).setParentMessageSource(parent);
                }

                return bean;
            }
        };
    }
}
