package com.gxufe.smarcampus.common.util;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * Json转换工具类
 * 对jackson二次封装
 * @author Administrator
 *
 */
public class JsonUtils {
    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    //Object转换json字符串
    public static String objectToJson(Object data) {
    	String str = null;
    	try {
			str = OBJECTMAPPER.writeValueAsString(data);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return str;
    }
    
    //json转换Object
    public static <T> T jsonToObject(String jsonData, Class<T> beanType) {
    	T t = null;
        try {
            t = OBJECTMAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return t;
    }
    
    
    //json转换list
    public static <T>List<T> jsonToList(String jsonData, Class<T> beanType) {
    	JavaType javaType = OBJECTMAPPER.getTypeFactory().constructParametricType(List.class, beanType);
    	List<T> list = null;
    	try {
    		list = OBJECTMAPPER.readValue(jsonData, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return list;
    }
    
}
