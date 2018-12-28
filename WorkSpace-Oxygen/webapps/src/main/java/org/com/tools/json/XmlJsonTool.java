package org.com.tools.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.xml.XMLSerializer;

public class XmlJsonTool {

	/**

	* XML转换为JSON

	* 2017-4-27 15:32:53

	* @param xml

	* @return

	*/

	public static String xmlToJson(String xml) {

	XMLSerializer serializer = new XMLSerializer();

	return serializer.read(xml).toString();

	}
	
	
	
	
	/**

	* JSON 转换为XML

	* 2017年4月27日 15:34:24

	* @param json

	* @return

	*/

	public static String jsonToXML(String json) {

	XMLSerializer xmlSerializer = new XMLSerializer();

	// 根节点名称

	xmlSerializer.setRootName("xml");

	// 不对类型进行设置

	xmlSerializer.setTypeHintsEnabled(false);

	String xmlStr = "";

	if (json.contains("[") && json.contains("]")) {

	// jsonArray

	JSONArray jobj = JSONArray.fromObject(json);

	xmlStr = xmlSerializer.write(jobj);

	} else {

	// jsonObject

	JSONObject jobj = JSONObject.fromObject(json);

	xmlStr = xmlSerializer.write(jobj);

	}

	System.out.println("转换后的参数：" + xmlStr);

	return xmlStr;

	}
	
	
	
}
