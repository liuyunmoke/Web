package com.pipipark.j.mvc.core;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import com.pipipark.j.system.IPPPark;
import com.pipipark.j.system.core.PPPString;

@SuppressWarnings("serial")
public abstract class PPPContext implements IPPPark {

	public static class Spring implements ApplicationContextAware {

		private static ApplicationContext _applicationContext;

		/**
		 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
		 * 
		 * @param applicationContext
		 * @throws BeansException
		 */
		public void setApplicationContext(ApplicationContext applicationContext)
				throws BeansException {
			_applicationContext = applicationContext;
		}

		/**
		 * @return ApplicationContext
		 */
		public static ApplicationContext getApplicationContext() {
			return _applicationContext;
		}

		/**
		 * 获取对象
		 * 
		 * @param name
		 * @return Object 一个以所给名字注册的bean的实例
		 * @throws BeansException
		 */
		public static Object getBean(String name){
			try{
				return _applicationContext.getBean(name);
			}catch(BeansException e){
				return null;
			}
		}

		/**
		 * 获取类型为requiredType的对象
		 * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
		 * 
		 * @param name
		 *            bean注册名
		 * @param requiredType
		 *            返回对象类型
		 * @return Object 返回requiredType类型对象
		 * @throws BeansException
		 */
		public static <M> M getBean(String name, Class<M> requiredType){
			try{
				return _applicationContext.getBean(name, requiredType);
			}catch(BeansException e){
				return null;
			}
		}

		/**
		 * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
		 * 
		 * @param name
		 * @return boolean
		 */
		public static boolean containsBean(String name) {
			return _applicationContext.containsBean(name);
		}

		/**
		 * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
		 * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
		 * 
		 * @param name
		 * @return boolean
		 * @throws NoSuchBeanDefinitionException
		 */
		public static boolean isSingleton(String name)
				throws NoSuchBeanDefinitionException {
			return _applicationContext.isSingleton(name);
		}

		/**
		 * @param name
		 * @return Class 注册对象的类型
		 * @throws NoSuchBeanDefinitionException
		 */
		public static Class<?> getType(String name)
				throws NoSuchBeanDefinitionException {
			return _applicationContext.getType(name);
		}

		/**
		 * 如果给定的bean名字在bean定义中有别名，则返回这些别名
		 * 
		 * @param name
		 * @return
		 * @throws NoSuchBeanDefinitionException
		 */
		public static String[] getAliases(String name)
				throws NoSuchBeanDefinitionException {
			return _applicationContext.getAliases(name);
		}

		/**
		 * 动态注册Bean
		 * @param service
		 */
		public static void addBean(Class<?> beanClass) {
			String name = PPPString.aliasName(beanClass);
			if (!_applicationContext.containsBean(name)) {
				BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
						.genericBeanDefinition(beanClass);
				ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) _applicationContext;
				BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
						.getBeanFactory();
				beanDefinitonRegistry.registerBeanDefinition(name,
						beanDefinitionBuilder.getRawBeanDefinition());
			}
		}
	}
}
