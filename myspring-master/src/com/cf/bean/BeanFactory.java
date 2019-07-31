/**
 * 
 */
package com.cf.bean;


public interface BeanFactory {
	
	/**
	 * 通过指定名字获取bean
	 *
	 * @param name
	 * @return
	 */
	Object getBean(String name);
	
}
