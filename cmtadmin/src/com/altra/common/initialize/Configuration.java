package com.altra.common.initialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * 读取资源文件共同方法
 */
public class Configuration {
	public static String getReourcesV(String key) {
		ResourceBundle bundle = ResourceBundle
				.getBundle("configuration");
		return bundle.getString(key);
	}
	public static void setReourcesV(String key,String value) {
		 OutputStream fos = null ;
		 InputStream is = null;
		Properties p = new Properties();
		try {
			File file = new File(Configuration.class.getResource("/configuration.properties").getFile());
			is =  new FileInputStream(file.getPath());
			p.load(is);
			fos = new FileOutputStream(file.getPath());
            p.setProperty(key, value);
            p.store(fos, null);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			p = null;
			try {
				if(is !=null ) is.close();
				if(fos !=null ) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
