package com.qm.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qm.common.domain.LocalInfo;
import com.qm.dao.BusinessLogDao;
import com.qm.domain.entity.BusinessLog;



/**
 * 记录业务日志
 * 创建日期：2015年5月11日
 * @author niezhegang
 */
@Service
public class BusinessLogService {
	@Autowired
	private BusinessLogDao businessLogDao;
	
	private final static String SourCharset  = "iso-8859-1";
	private final static String DistCharset = "utf-8";
	//private final static String ParamName_UserID = "userLog"; 
	private final static String ParamName_UserID = "UserID"; 
	private final static String ParamName_UserLog = "userLog"; 
	public BusinessLogDao getBusinessLogDao() {
		return businessLogDao;
	}

	public void setBusinessLogDao(BusinessLogDao businessLogDao) {
		this.businessLogDao = businessLogDao;
	}
	
	/**
	 * 保存业务访问日志
	 * @param request         
	 * 创建日期：2015年5月11日
	 * 修改说明：
	 * @author niezhegang
	 */
	public void writeRequestAccessLog(HttpServletRequest request) throws UnsupportedEncodingException{
		BusinessLog businessLog = new BusinessLog();
		businessLog.setURL(transcode(request.getServletPath(),DistCharset));
		businessLog.setRemoteIP(request.getRemoteAddr());
		businessLog.setAccessParams(transcode(request.getQueryString(),DistCharset));
		businessLog.setOperatorTime(new Date());
		String userID = request.getParameter(ParamName_UserID);

		//存储用户信息
		LocalInfo.setVal(userID);

		String userLog = request.getParameter(ParamName_UserLog);
		if(StringUtils.isEmpty(userLog)){
			HttpSession session=request.getSession();
			userLog=(String) session.getAttribute("openid");
		}

		if(StringUtils.isNotBlank(userID)){
			businessLog.setUserID(userID);
		}
		if(StringUtils.isNotBlank(userLog)){
			businessLog.setUserLog(userLog);
		}
		businessLogDao.insert(businessLog);
	}
	
	/**
	 * 字符转码
	 * @param source
	 * @param distCharSet
	 * @return
	 * @throws UnsupportedEncodingException
	 * 创建日期：2015年5月11日
	 * 修改说明：
	 * @author niezhegang
	 */
	private String transcode(String source,String distCharSet) throws UnsupportedEncodingException{
		String ret = source;
		if(StringUtils.isNotBlank(ret)){
			ret = URLDecoder.decode(source,distCharSet);
		}
		return ret;
	}

}
