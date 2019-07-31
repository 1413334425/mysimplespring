/**
 * 
 */
package com.cf.context;

/**
 * ClassPathXmlApplicationContext.java
 * 
 *
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	
	/**
	 * 构造方函数
	 * 
	 * @param fileName
	 */
	public ClassPathXmlApplicationContext(String fileName) {

		super.cfgFile = fileName;
		super.refresh();
	}

	
	
	
}
