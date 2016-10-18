package com.qm.common.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.ObjectTypeHandler;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.qm.common.exception.CustomException;
/**
 * 空string值类型处理器，因json格式返回数据没有类型定义
 * 当作为mybatis参数时，其所有值包括null值都作为string值返回,
 * 该类对空字符类型做一特殊处理
 * 创建日期：2013年8月14日
 * @author niezhegang
 */
public class EmptyStringTypeHandler extends BaseTypeHandler<String> {
	
	private static final ObjectTypeHandler OBJECT_TYPE_HANDLER = new ObjectTypeHandler();

	private TypeHandlerRegistry typeHandlerRegistry;
	
	@SuppressWarnings("unchecked")
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i,
			String parameter, JdbcType jdbcType) throws SQLException {
		// 需要特殊处理空字符
		if (StringUtils.isBlank(parameter) && emptyCharNeedProcessFor(jdbcType)) {
			if (jdbcType == null) {
				throw new CustomException(
						"JDBC requires that the JdbcType must be specified for all nullable parameters.");
			}
			try {
				ps.setNull(i, jdbcType.TYPE_CODE);
			} catch (SQLException e) {
				throw new CustomException(
						"Error setting null for parameter #"
								+ i
								+ " with JdbcType "
								+ jdbcType
								+ " . "
								+ "Try setting a different JdbcType for this parameter or a different jdbcTypeForNull configuration property. "
								+ "Cause: " + e, e);
			}
		} 
		else {
//			TypeHandler handler = typeHandlerRegistry.getTypeHandler(jdbcType);
//			if (handler == null || handler instanceof UnknownTypeHandler) {
//				handler = OBJECT_TYPE_HANDLER;
//			}
			@SuppressWarnings("rawtypes")
			TypeHandler handler = OBJECT_TYPE_HANDLER;
			handler.setParameter(ps, i, parameter, jdbcType);
		}
	}
	/**
	 * 判断是否空字符需要处理成null
	 * @param jdbcType
	 * @return
	 * 创建日期：2013年8月14日
	 * 修改说明：
	 * @author niezhegang
	 */
	private boolean emptyCharNeedProcessFor(JdbcType jdbcType){
		boolean bRet = true;
		if(jdbcType == JdbcType.CHAR ||
				jdbcType == JdbcType.VARCHAR ||
					jdbcType == JdbcType.NVARCHAR ||
					 	jdbcType == JdbcType.NCHAR ||
					 		jdbcType == JdbcType.CLOB || 
					 			jdbcType == JdbcType.LONGVARCHAR ||
					 				jdbcType == JdbcType.NCLOB)
			bRet = false;
		return bRet;
	}
	
	@Override
	public String getNullableResult(ResultSet rs, String columnName)
			throws SQLException {
		return null;
		//throw new SQLException("不应该执行该段代码");
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex)
			throws SQLException {
		return null;
		//throw new SQLException("不应该执行该段代码");
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex)
			throws SQLException {
		return null;
		//throw new SQLException("不应该执行该段代码");
	}
	
	public TypeHandlerRegistry getTypeHandlerRegistry() {
		return typeHandlerRegistry;
	}
	public void setTypeHandlerRegistry(TypeHandlerRegistry typeHandlerRegistry) {
		this.typeHandlerRegistry = typeHandlerRegistry;
	}
}
