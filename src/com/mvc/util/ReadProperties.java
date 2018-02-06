package com.mvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * 资源文件读取�?
 * 
 * @author tangming
 * @date 2015-11-13
 */
public class ReadProperties {

	private static String param;

	/**
	 * 私有构�?方法，不�?��创建对象
	 */
	private ReadProperties() {
	}

	public static String getParam() {
		return param;
	}

	public static String getProperties(String pram) {
		Properties prop = new Properties();
		InputStream in = ReadProperties.class.getClassLoader().getResourceAsStream("redis.properties");
		try {
			prop.load(in);
			param = prop.getProperty(pram).trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return param;
	}
}
