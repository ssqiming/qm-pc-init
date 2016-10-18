package com.qm.domain.databind;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.qm.common.utils.Base64SecurityUtils;

/**
 * 带加密的序列化器
 * 创建日期：2015年5月26日
 * @author niezhegang
 */
public class EncryptionJsonSerializer extends JsonSerializer<Long> {

	@Override
	public void serialize(Long value, JsonGenerator gen,
			SerializerProvider serializers) throws IOException,
			JsonProcessingException {
		if(value == null)
			gen.writeNull();
		else
			gen.writeString(Base64SecurityUtils.encryption(value.toString()));
	}

}
