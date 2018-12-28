package org.com.tools.jsontest;

import org.json.JSONObject;
import org.json.XML;

import net.sf.json.xml.XMLSerializer;

public class XmlJsonTest {

	
	
	public static void main(String[] args) {  
        String xml = "<class id="  
                + "'1'"  
                + "><student><name>aaaaaa</name><age>21</age></student><student><name>bbbbbb</name><age>22</age></student></class>";  
  
        /* 第一种方法，使用JSON-JAVA提供的方法 */  
        //将xml转为json  
        JSONObject xmlJSONObj = XML.toJSONObject(xml);  
        //设置缩进  
        String jsonPrettyPrintString = xmlJSONObj.toString(4);  
        //输出格式化后的json  
        System.out.println(jsonPrettyPrintString);  
  
        /* 第二种方法，使用json-lib提供的方法 */  
        //创建 XMLSerializer对象  
        XMLSerializer xmlSerializer = new XMLSerializer();  
        //将xml转为json（注：如果是元素的属性，会在json里的key前加一个@标识）  
        String result = xmlSerializer.read(xml).toString();  
        //输出json内容  
        System.out.println(result);  
  
    }  
}
