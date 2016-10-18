package com.qm.common.domain;

import java.io.IOException;

import org.springframework.beans.factory.FactoryBean;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * ObjectMapper工厂Bean
 * 
 * @created 2014年5月26日
 * @author  niezhegang
 */
public class ObjectMapperFactoryBean implements FactoryBean<ObjectMapper> {

	/**
	 * @see org.springframework.beans.factory.FactoryBean#getObject()
	 * @created 2014年5月26日
	 * @author  niezhegang
	 */
	@Override
	public ObjectMapper getObject() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		//允许转换没有属性的Bean对象
		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		//设置反序列化时忽略在JSON字符串中存在但Java对象实际没有的属性
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return objectMapper;
	}

	/**
	 * @see org.springframework.beans.factory.FactoryBean#getObjectType()
	 * @created 2014年5月26日
	 * @author  niezhegang
	 */
	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	/**
	 * @see org.springframework.beans.factory.FactoryBean#isSingleton()
	 * @created 2014年5月26日
	 * @author  niezhegang
	 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	/**
	 * ToString JSON序列化器
	 * 
	 * @created 2014年5月26日
	 * @author  niezhegang
	 */
	public static class ToStringSerializer extends JsonSerializer<Object> {
		@Override
		public void serialize(Object value, JsonGenerator generator, SerializerProvider provider)
				throws IOException, JsonProcessingException {
			if(value == null) {
				generator.writeNull();
			} else {
				generator.writeString(value.toString());
			}
		}
	}

}
