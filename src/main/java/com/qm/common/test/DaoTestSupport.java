package com.qm.common.test;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Log4jConfigurer;

/**
 * dao测试基础类,需要测试mybatis的dao接口的继承此类，支持自动回滚
 * 创建日期：2014年8月2日
 * @author niezhegang
 */
@TransactionConfiguration(transactionManager="txManager")
@RunWith(MySpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*-spring.xml")
public abstract class DaoTestSupport extends AbstractTransactionalJUnit4SpringContextTests{
	 static {  
	        try {  
	            Log4jConfigurer.initLogging("classpath:config/test.log4j.properties");  
	        } catch (FileNotFoundException ex) {  
	            System.err.println("Cannot Initialize log4j");  
	        }  
	    }  
	
	@Before  
	public void init() throws Exception{ 
		//mockito支持
    	MockitoAnnotations.initMocks(this);
	}	
	
}
