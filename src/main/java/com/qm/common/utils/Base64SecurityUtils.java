package com.qm.common.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

/**
 * 基于base64的安全工具类
 * 支持循环加密次数，暂时不支持加salt
 * 创建日期：2015年5月26日
 * @author niezhegang
 */
public class Base64SecurityUtils {
	/**循环加密次数*/
	private final static int Loops = 8;
	
	/**
	 * 加密
	 * @param source
	 * @return
	 * 创建日期：2015年5月26日
	 * 修改说明：
	 * @author niezhegang
	 */
	public static String  encryption(String source){
		String ret = source;
		if(StringUtils.isNotBlank(ret)){
			for(int i = 0 ; i < Loops ; i++){
				ret = Base64.encodeBase64String(ret.getBytes());
			}
		}
		return ret;
	}
	
	/**
	 * 解密
	 * @param dest
	 * @return
	 * 创建日期：2015年5月26日
	 * 修改说明：
	 * @author niezhegang
	 */
	public static String decryption(String dest){
		String ret = dest;
		if(StringUtils.isNotBlank(dest)){
			for(int i = 0 ; i < Loops ; i++){
				ret = new String(Base64.decodeBase64(ret));
			}
		}
		return ret;
	}

}
