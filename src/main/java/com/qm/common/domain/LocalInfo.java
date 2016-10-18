package com.qm.common.domain;
/**
 * 本地线程，用于存储用户名
 * @author 001362
 *
 */
public class LocalInfo {
	private static ThreadLocal threadLocal = new ThreadLocal();
	
	public static void  setVal(String val){
		threadLocal.set(val);
	}
	
	public static String getVal(){
		return (String)threadLocal.get();
	}
}
