package com.netbrain.test.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author gaohuan
 *
 * 2016年9月12日下午8:37:58
 */
public class JsonParse {
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(JsonParse.class);

	private final static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * @param map
	 * @return Map转Json
	 */
	public static String map2Json(Map<String, Object> map) {

		String json = null;
		if (map == null) {
			return "";
		}
		try {
			json = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(json);
		// logger.info(json);
		return json;

	}
	
	public static String getFromKey(String key, String result) {
		JsonNode node;
		try {
			node = objectMapper.readTree(result);
			JsonNode codeNode = node.get("operationResult").get(key);
			String codeText = codeNode.asText();
			if (codeText.equals("null")) {
				return "null";
			} else {
				return codeText;
			}
		} catch (IOException e) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(baos));
			String exception = baos.toString();
			logger.error(" - [LOG_EXCEPTION] - " + exception);
			logger.error(" - [LOG_RESULT] - " + result);
			return null;
		}
	}

}
