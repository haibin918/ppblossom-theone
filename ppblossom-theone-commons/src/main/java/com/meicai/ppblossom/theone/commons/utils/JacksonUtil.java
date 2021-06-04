package com.meicai.ppblossom.theone.commons.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * json 对象相互转换处理
 *
 */
@Slf4j
public class JacksonUtil {


	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String obj2Str(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			log.error("obj convert to Str error.", e);
		}
		return null;
	}

	public static <T> T str2Obj(String json, Class<T> clazz) {
		try {
			return objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			log.error("Str convert to Obj error.", e);
		}
		return null;
	}

	public static <T> T JSONToPOJO(String json, TypeReference<T> type) {
		T clazz = null;
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		try {
			clazz = objectMapper.readValue(json, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return clazz;
	}
}
