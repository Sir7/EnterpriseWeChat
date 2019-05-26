/**
 * <p>Copyright:Copyright(c) 2014</p>
 * <p>Company:上海中信信息发展股份有限公司</p>
 * <p>包名:com.ces.prison.common.tools</p>
 * <p>文件名:JsonUtil.java</p>
 * <p>类更新历史信息</p>
 * @todo admin(冯有双  E-mail:feng.youshuang@cesgroup.com.cn) 
 * 创建于 2014-12-29 上午11:02:18
 */
package com.alphabet.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;

/**
 * <p>描述:</p>
 * @author admin(冯有双 E-mail:feng.youshuang@cesgroup.com.cn)
 * @date 2014-12-29  上午11:02:18
 * @version 1.0.2014.
 */
public class JsonUtil implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * 获取jsonStr中的属性值
	 * @param jsonStr
	 * @param key
	 * @return
	 */
	public static String getAttribute(String jsonStr,String key){
		jsonStr=initJsonStr(jsonStr);
		JsonConfig jsonConfig =null; 
		JSONArray jsonArray=null;
		jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode( JsonConfig.MODE_OBJECT_ARRAY );
		jsonConfig.setRootClass(String.class); 
	    jsonArray=JSONArray.fromObject(jsonStr, jsonConfig);
	    if(jsonArray!=null&&jsonArray.getJSONObject(0)!=null){
	      return jsonArray.getJSONObject(0).getString(key);
	    }else{
	      return null;
	    }
	}
	
	 
	/**
	 *  根据json串得到它的属性值    空值和null值被忽略
	 * @param jsonStr
	 * @return 
	 */
	public static Map getAttributesIngoreNull(String jsonStr) {
		try {
			Map[] maps = getAttributes(jsonStr, null, true);
			if (maps != null && maps.length > 0) {
				return maps[0];
			}
		} catch (Exception e) {
			System.out.println("json串转化失败！" + jsonStr);
		}
		return null;
	}

	public static Map getAttributesIngoreNull(String jsonStr, Map map) {
		Map[] maps = getAttributes(jsonStr, map, true);
		if (maps != null && maps.length > 0) {
			return maps[0];
		} else {
			return null;
		}
	}
	
	/**
	 *  根据json串得到它的属性值  不忽略空值和null
	 * @param jsonStr
	 * @return 
	 */
	public static Map getAttributes(String jsonStr) {
		Map[] maps = getAttributes(jsonStr, null, false);
		if (maps != null && maps.length > 0) {
			return maps[0];
		} else {
			return null;
		}
	}

	public static Map getAttributes(String jsonStr, Map map) {
		Map[] maps = getAttributes(jsonStr, map, false);
		if (maps != null && maps.length > 0) {
			return maps[0];
		} else {
			return null;
		}
	}
	
	
	/**
	 * jsonStr  对于jsonStr是list 或 array  生成的
	 * 返回数组或List列表
	 * @param jsonStr
	 * @return
	 */
	
	public static Map[] getAttributesToMaps(String jsonStr) {
		return getAttributes(jsonStr, null, false);
	}

	public static Map[] getAttributesToMapsIngoreNull(String jsonStr) {
		return getAttributes(jsonStr, null, true);
	}

	public static Map[] getAttributesToMaps(String jsonStr, Map map) {
		return getAttributes(jsonStr, map, false);
	}

	public static Map[] getAttributesToMapsIngoreNull(String jsonStr, Map map) {
		return getAttributes(jsonStr, map, true);
	}
	
	
	
	/**
	 * 根据json串得到它的属性值   
	 * @param jsonStr
	 * @param map 要取哪些值，及这些在返回的map中以什么key值存放
	 *        key  为json串的属性名称
	 *        value 为return map中的key值,如果value为空(null 或 "")，则key值与json串中的属性名称相同
	 * @param ingoreNull   true 空值和null值被忽略   false 不忽略
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static Map[] getAttributes(String jsonStr, Map map,boolean ingoreNull) {
		Map[] rmap = null;
		Iterator iterator = null;
		Entry entry = null;
		String key = null;
		String value = null;
		String attValue = null;
		JsonConfig jsonConfig = null;
		JSONArray jsonArray = null;

		jsonStr = initJsonStr(jsonStr);
		if (jsonStr != null && !jsonStr.trim().equals("")) {
			if (!jsonStr.trim().startsWith("[")) {
				jsonStr = new StringBuffer("[").append(jsonStr).append("]").toString();
			}
			jsonConfig = new JsonConfig();
			jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
			jsonConfig.setRootClass(String.class);
			jsonArray = JSONArray.fromObject(jsonStr, jsonConfig);
			if (jsonArray == null || jsonArray.size() == 0) {
				return null;
			}
			rmap = new HashMap[jsonArray.size()];
			for (int i = 0; i < jsonArray.size(); i++) {
				rmap[i] = new HashMap();
				if (map != null && map.size() > 0) {
					iterator = map.entrySet().iterator();
					while (iterator.hasNext()) {
						entry = (Entry) iterator.next();
						key = (String) entry.getKey();
						value = (String) entry.getValue();

						attValue = jsonArray.getJSONObject(i).getString(key);
						if (ingoreNull) {
							if (attValue != null && !attValue.trim().equals("")
									&& !attValue.equals("null")
									&& !attValue.equals("undefined")) {
								rmap[i].put(value == null|| value.trim().equals("") ? key: value, attValue.trim());
							}
						} else {
							rmap[i].put(value == null|| value.trim().equals("") ? key : value,attValue == null ? null : attValue.trim());
						}
					}
				} else {
					iterator = jsonArray.getJSONObject(i).keySet().iterator();
					while (iterator.hasNext()) {
						key = (String) iterator.next();
						attValue = jsonArray.getJSONObject(i).getString(key);
						if (ingoreNull) {
							if (attValue != null && !attValue.trim().equals("")
									&& !attValue.equals("null")
									&& !attValue.equals("undefined")) {
								rmap[i].put(key, attValue.trim());
							}
						} else {
							rmap[i].put(key,attValue == null ? null : attValue.trim());
						}
					}
				}
			}
		}
		return rmap;
	}
	
	
	/**
	 * 将String数组转成json串
	 * @param array
	 * @return
	 */
	public static String stringArrayToJsonStr(String[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i].startsWith("'") && array[i].endsWith("'")) {
				array[i] = "\'''"+ array[i].substring(1, array[i].length() - 1) + "\'''";
			} else if (array[i].startsWith("\"") && array[i].endsWith("\"")) {
				array[i] = "\''\""+ array[i].substring(1, array[i].length() - 1)+ "\"\''";
			}
			jsonArray.add(array[i]);
		}
		return jsonArray.toString();
	}
	
	/**
	 * 将json串转成String数组
	 * @param jsonStr
	 * @return
	 */
	public static String[] jsonStrToStringArray(String jsonStr) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}

		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
		jsonConfig.setRootClass(String.class);

		JSON json = JSONSerializer.toJSON(jsonStr, jsonConfig);
		return (String[]) JSONSerializer.toJava(json, jsonConfig);
	}
	
	/**
	 * json串转成对象
	 * @param jsonStr
	 * @param c
	 * @return
	 */

	public static Object jsonStrToObject(String jsonStr, Class c) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		Object list = jsonStrToListOb(jsonStr, c);
		return list;
	}
	
	/**
	 * json串转成List列表
	 * @param jsonStr
	 * @param c
	 * @return
	 */
	public static List jsonStrToList(String jsonStr, Class c) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = initJsonStr(jsonStr);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_LIST);
		jsonConfig.setRootClass(c);
		JSON json = JSONSerializer.toJSON(jsonStr, jsonConfig);
		return (List) JSONSerializer.toJava(json, jsonConfig);
	}
	
	/**
	 * json串转成List列表
	 * @param jsonStr
	 * @param c
	 * @return
	 */
	public static Object jsonStrToListOb(String jsonStr, Class c) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = initJsonStr(jsonStr);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_LIST);
		jsonConfig.setRootClass(c);
		JSON json = JSONSerializer.toJSON(jsonStr, jsonConfig);
		return JSONSerializer.toJava(json, jsonConfig);
	}
	
	
	/**
	 * json串转成List列表
	 * @param jsonStr
	 * @param c
	 * @return
	 */
	public static List jsonStrToListExcute(String jsonStr, Class c) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = initJsonStr(jsonStr);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_LIST);
		jsonConfig.setExcludes(new String[] { "id" });
		jsonConfig.setRootClass(c);
		JSON json = JSONSerializer.toJSON(jsonStr, jsonConfig);
		return (List) JSONSerializer.toJava(json, jsonConfig);
	}
	
	/**
	 * json串转成Object数组
	 * @param jsonStr
	 * @param c
	 */
	
	public static Object[] jsonStrToArray(String jsonStr, Class c) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = initJsonStr(jsonStr);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_OBJECT_ARRAY);
		jsonConfig.setRootClass(c);
		JSON json = JSONSerializer.toJSON(jsonStr, jsonConfig);
		return (Object[]) JSONSerializer.toJava(json, jsonConfig);
	}
	
	/**
	 * 对象转换成jsonStr
	 * @param object  
	 * @return
	 */
	public static String objectToJsonStr(Object object) {
		if (object == null
				|| (object instanceof List && ((List) object).size() == 0)
				|| (object instanceof Map && ((Map) object).size() == 0)
				|| (object instanceof Set && ((Set) object).size() == 0)) {
			return null;
		}
		JSONArray jsonArray = JSONArray.fromObject(object);
		return jsonArray.toString();
	}
	
	public static JSONArray jsonStrToJSONArray(String jsonStr) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = initJsonStr(jsonStr);
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setArrayMode(JsonConfig.MODE_LIST);
		jsonConfig.setRootClass(String.class);
		return JSONArray.fromObject(jsonStr, jsonConfig);
	}
	
	public static String addAttribute(String jsonStr, String attributeKey,
			Object attributeValue) {
		JSONArray jsonArray = jsonStrToJSONArray(jsonStr);
		JSONObject jo = null;
		if (jsonArray == null || jsonArray.size() == 0) {
			jo = new JSONObject();
			jo.put(attributeKey, attributeValue);
			return new StringBuffer("[").append(jo.toString()).append("]")
					.toString();
		} else {
			for (int i = 0; i < jsonArray.size(); i++) {
				jo = (JSONObject) jsonArray.getJSONObject(i);
				jo.put(attributeKey, attributeValue);
				jsonArray.set(i, jo);
			}
			return jsonArray.toString();
		}
	}  

	public static String removeAttribute(String jsonStr, String attributeKey) {
		JSONArray jsonArray = jsonStrToJSONArray(jsonStr);
		JSONObject jo = null;
		if (jsonArray == null || jsonArray.size() == 0) {
			return null;
		} else {
			for (int i = 0; i < jsonArray.size(); i++) {
				jo = (JSONObject) jsonArray.getJSONObject(i);
				jo.remove(attributeKey);
				jsonArray.set(i, jo);
			}
			return jsonArray.toString();
		}
	}

	public static String replaceAttribute(String jsonStr, String attributeKey,
			Object attributeValue) {
		JSONArray jsonArray = jsonStrToJSONArray(jsonStr);
		JSONObject jo = null;
		if (jsonArray == null || jsonArray.size() == 0) {
			return null;
		} else {
			for (int i = 0; i < jsonArray.size(); i++) {
				jo = (JSONObject) jsonArray.getJSONObject(i);
				if (jo.containsKey(attributeKey)) {
					jo.remove(attributeKey);
					jo.put(attributeKey, attributeValue);
				}
				jsonArray.set(i, jo);
			}
			return jsonArray.toString();
		}

	}
	
	private static String initJsonStr(String jsonStr) {
		if (jsonStr == null || jsonStr.trim().equals("")) {
			return null;
		}
		jsonStr = jsonStr.replaceAll("\r", "\\\\r").replaceAll("\n", "\\\\n");
		return jsonStr;
	}
	 
	public static Map<String, Object> parseJSON2Map(String jsonStr) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(parseJSON2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

}
