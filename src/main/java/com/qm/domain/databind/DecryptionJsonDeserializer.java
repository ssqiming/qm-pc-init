package com.qm.domain.databind;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.qm.common.utils.Base64SecurityUtils;

/**
 * 带解密的反序列化器
 * 创建日期：2015年5月26日
 * @author niezhegang
 */
public class DecryptionJsonDeserializer extends JsonDeserializer<Long>{

	@Override
	public Long deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String value = p.getValueAsString();
		value = Base64SecurityUtils.decryption(value);
		if(StringUtils.isBlank(value))
			return null;
		else
			return Long.parseLong(value);
	}
	
}
