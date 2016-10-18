package com.qm.common.mybatis;

import java.io.IOException;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;

/**
 * 继承实现定制化SqlSessionFactoryBean
 * 创建日期：2013年8月14日
 * @author niezhegang
 */

public class MySqlSessionFactoryBean extends SqlSessionFactoryBean {

	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		SqlSessionFactory sqlSessionFactory = super.buildSqlSessionFactory();
		Configuration configuration = sqlSessionFactory.getConfiguration();
		registerCustomTypeHandlers(configuration);
		return sqlSessionFactory;
	}
	/**
	 * 注册定制类型处理器
	 * @param configuration
	 * 创建日期：2013年8月14日
	 * 修改说明：
	 * @author niezhegang
	 */
	private void registerCustomTypeHandlers(Configuration configuration){
		EmptyStringTypeHandler emptyStringTypeHandler = new EmptyStringTypeHandler();
		emptyStringTypeHandler.setTypeHandlerRegistry(configuration.getTypeHandlerRegistry());
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BIGINT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.ARRAY, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BIT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.TINYINT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.SMALLINT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.INTEGER, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BIGINT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.FLOAT, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.REAL, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.DOUBLE, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.NUMERIC, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.DECIMAL, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.DATE, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.TIME, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.TIMESTAMP, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BINARY, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.VARBINARY, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.LONGVARBINARY, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.NULL, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.OTHER, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BLOB, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.BOOLEAN, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.CURSOR, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.UNDEFINED, emptyStringTypeHandler);
		configuration.getTypeHandlerRegistry().register(String.class, JdbcType.STRUCT, emptyStringTypeHandler);
	}
	
}
