package com.snf.util;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {

	public static <T> T fromJson(String json, Class<T> returnType) {
		T retorno = null;
		try{
			Feature f1 = Feature.FAIL_ON_UNKNOWN_PROPERTIES;
			ObjectMapper om = new ObjectMapper().configure(f1, false);
			retorno = om.readValue(json, returnType);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
	public static <T> List<T> getCollectionfromJson(String json, Class<T> returnType) {
		List<T> retorno = new ArrayList<>();
		try{
			Feature f = Feature.FAIL_ON_UNKNOWN_PROPERTIES;
			ObjectMapper om = new ObjectMapper().configure(f, false);
			retorno = om.readValue(json, om.getTypeFactory().constructCollectionType(List.class, returnType));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return retorno;
	}
	
}
