package com.qm.web.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;

public class HttpClientClass {
	public String excute(String str){
		String responseBody="";
        HttpClient httpClient = new HttpClient();
        PostMethod postMethod=new PostMethod();
        GetMethod getMethod = new GetMethod(str);
        postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                        new DefaultHttpMethodRetryHandler());
        
        try
        {
                int statusCode = httpClient.executeMethod(getMethod);
                if (statusCode != HttpStatus.SC_OK)
                {
                        System.err.println("Method failed: "
                                        + getMethod.getStatusLine());
                }
                
                responseBody = getMethod.getResponseBodyAsString();
                if(responseBody.indexOf("Exception")>-1){
                	responseBody="";
                }
               

                } catch (HttpException e)
        {
                System.out.println("Please check your provided http address!");
                e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
    }catch (IOException e)
        {
                e.printStackTrace();
        } finally
        {
                getMethod.releaseConnection();
        }
        System.out.println("responseBody:"+responseBody);
	return responseBody;
	}
	public String subStringOpenid(String content){
		String []arg={};
		String openid="";
		String openidString="";
		String []openidStringarg={};
		if(!StringUtils.isEmpty(content)){
			arg=content.split(",");
		}
		if(arg.length>4)
			openidString=arg[3];
			if(!StringUtils.isEmpty(openidString))
				openidStringarg=openidString.split(":");
				if(openidStringarg.length>1)
					openid=openidStringarg[1].replace("\"", "");
			return openid;
		}
}
