package com.kolamomo.spring.demo.lifecycle;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.kolamomo.spring.demo.lifecycle.User;

/**
 * Created by jiangchao on 16/1/13.
 */
public class LifeCycleUserBeanTest {
    @Test
    public void testGetCustomElement() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("lifecycle/applicationContext.xml");
        User user = (User)context.getBean("user");
        System.out.println("user id = " + user.getId() + ", name = " + user.getName());
        context.destroy();
    }
}

/*
//输出结果如下：
//bean的生命周期包含三类方法：
//1. bean自身的方法
//2. bean级生命周期的接口方法
//3. beanFactory级生命周期的接口方法

//调用构造函数
3 --- call MyBeanFactoryPostProcessor.postProcessBeanFactory() name=TypedStringValue: value [kolamomo], target type [null] ---
3 --- call InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation() ---
1 --- call User constructor ---
3 --- call InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation() ---

//调用set方法
3 --- call InstantiationAwareBeanPostProcessor.postProcessProertyValues() ---
1 --- call User set method: setName() ---
2 --- call BeanNameAware.setBeanName() ---
2 --- call BeanFactoryAware.setBeanFactory() ---
2 --- call ApplicationContextAware.setApplicationContext() ---

//调用init方法
3 --- call MyBeanPostProcessor.postProcessBeforeInstantiation() name=kolamomo ---
2 --- call InitializingBean.afterPropertiesSet() ---
1 --- call User init-method: init() ---
3 --- call MyBeanPostProcessor.postProcessAfterInstantiation() name=kolamomo ---

//使用bean
user id = 1, name = kolamomo

//容器销毁，调用destroy方法
2 --- call DisposableBean.destroy() ---
1 --- call User destroy-method: destroyMethod() ---
*/