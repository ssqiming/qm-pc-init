package com.qm.common.utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.qm.web.utils.Pagination;


/** 
 * @ClassName: Common 
 * @Description: 公用抽象类 
 * @author caizhen
 * @date 2015年8月8日 下午11:05:00  
 */
public abstract class Common {
	public static final String SESSION_USER="userSession";//存放登录用户信息
	public static final String ADMIN_AUTH = "admin";//admin权限
	public static final String SESSION_ADMIN = "adminSession";//存放管理员权限信息	
	public static final String SESSION_AUTH = "authSession";//存放用户权限信息
	//存放图片的路径
//	public static final String localPath = "E:\\";
//	public static final String localPath = "D:\\Program Files (x86)\\apache-tomcat-7.0.42\\wtpwebapps\\";
//	public static final String storePath = "xjProject_pic" + File.separator;//+ user.getId() + File.separator;
	//存放图片的服务器地址(测试)
//	public static final String photoPath="http://172.16.2.157:8080/";
//	public static final String localPath = File.separator+"usr"+File.separator+"local"+File.separator+"apache-tomcat-7.0.42"+File.separator+"webapps"+File.separator;
	//存放图片的服务器地址(微信测试)
//	public static final String photoPath="http://172.16.2.210:80/";
//	public static final String localPath = File.separator+"usr"+File.separator+"local"+File.separator+"apache-tomcat-7.0.42"+File.separator+"webapps"+File.separator;
	//存放图片的服务器地址(62)
//	public static final String photoPath="http://10.50.30.62:80/";
//	public static final String localPath = File.separator+"usr"+File.separator+"local"+File.separator+"tomcat"+File.separator+"webapps"+File.separator;
	//存放图片的服务器地址(121)
	public static final String photoPath="http://image.junong365.cn/";
	public static final String localPath = File.separator+"usr"+File.separator+"local"+File.separator+"tomcat"+File.separator+"webapps"+File.separator;
	
	/**
	 * 方法说明：输出text/plain字符串到response
	 * 上传文件使用
	 * @param xmlStr
	 */
	public static void outJson(String jsonStr,HttpServletResponse response) {
		response.setContentType("text/plain;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
		out = response.getWriter();
		if(jsonStr==null){
			jsonStr="";
		}
		out.write(jsonStr);
		} catch (Exception e) {
		e.printStackTrace();
		}finally{
		if(null != out)
		out.close();
		}
	}
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s.trim()))
			return true;
		return false;
	}

	/**
	 * 判断字符串是否非空
	 */
	public static boolean isNotEmpty(String s) {
		if (null == s || "".equals(s.trim()))
			return false;
		return true;
	}
	/**
	 * @Title: getPagination 
	 * @Description: 封装分页信息
	 * @author caizhen   
	 * @param @param dataList
	 * @param @param total
	 * @param @param params
	 * @param @return    设定文件 
	 * @return Pagination    返回类型 
	 * @throws
	 */
	public static Pagination getPagination(List dataList,int total,Map<String,Object> params){
		int pageSize = (Integer)params.get("pageSize");
		int currentPage = (Integer)params.get("currentPage");
		// 计算总页数
        Integer totalPage = total % pageSize == 0 ? (total / pageSize)
            : (total / pageSize) + 1;
        if (totalPage > 0 && currentPage > totalPage) {
        	currentPage = totalPage;
        }
        
        Pagination pagination = new Pagination(dataList,total,currentPage,pageSize);

        return pagination;
	}
	/**
	 * @Title: getPaginationParam 
	 * @Description: 设置分页参数
	 * @author caizhen   
	 * @param @param request
	 * @param @param params
	 * @param @return    设定文件 
	 * @return Map<String,Object>    返回类型 
	 * @throws
	 */
	public static Map<String,Object> getPaginationParam(HttpServletRequest request,Map<String,Object> params){
		//设置默认分页参数
		Integer startIndex=0;
		Integer currentPage=1;
		Integer pageSize = 5;
		//获取分页信息
		if(StringUtils.isNotBlank(request.getParameter("currentPage"))&&StringUtils.isNotBlank(request.getParameter("currentPage"))){
			currentPage=Integer.parseInt(request.getParameter("currentPage"))>0?Integer.parseInt(request.getParameter("currentPage")):1;
			startIndex=(currentPage-1)*pageSize;//查询开始下标
		}
        
    	params.put("startIndex",startIndex);
		params.put("endIndex",pageSize);
		params.put("currentPage",currentPage);
		params.put("pageSize",pageSize);
		return params;
	}
	
	public static String getRandomCharAndNumr(Integer length) {  
	    String str = "";  
	    Random random = new Random();  
	    for (int i = 0; i < length; i++) {  
	        boolean b = random.nextBoolean();  
	        if (b) { // 字符串  
	            int choice = random.nextBoolean() ? 65 : 97;// 取得65大写字母还是97小写字母  
	            str += (char) (choice + random.nextInt(26));// 取得大写字母  
	        } else { // 数字  
	            str += String.valueOf(random.nextInt(10));  
	        }  
	    }  
	    return str;  
	} 
	/**
	 * @Title: randomCode 
	 * @Description: 根据length生成n为随机数
	 * @author caizhen   
	 * @param @param length
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 */
    public static String randomCode(int length){
    	StringBuffer sb=new StringBuffer();
    	String chars="0123456789";
    	for(int i=0;i<4;i++){
    		int rand=(int)(Math.random()*10);
    		sb.append(chars.charAt(rand));
    	}
    	return sb.toString();
    }
}
