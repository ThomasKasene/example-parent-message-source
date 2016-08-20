package com.thomaskasene.example.messagesource.parent;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
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
    BeanFactoryPostProcessor messageSourceCustomExtender() {
        return beanFactory -> {
            ResourceBundleMessageSource parent = new ResourceBundleMessageSource();
            parent.setBasename("custom");

            HierarchicalMessageSource child = beanFactory.getBean("messageSource", HierarchicalMessageSource.class);
            child.setParentMessageSource(parent);
        };
    }
}
