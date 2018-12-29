package org.com.tools.json;

import com.alibaba.fastjson.JSONObject;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by 1250052380@qq.com on 2015/5/19.
 */
public class XmlUtil {
	
	
  public static JSONObject xml2JSON(byte[] xml) throws JDOMException, IOException {
    JSONObject json = new JSONObject();
    InputStream is = new ByteArrayInputStream(xml);
    SAXBuilder sb = new SAXBuilder();
    org.jdom2.Document doc = sb.build(is);
    Element root = doc.getRootElement();
    json.put(root.getName(), iterateElement(root));
    return json;
  }
  
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
  private static JSONObject iterateElement(Element element) {
    List node = element.getChildren();
    Element et = null;
    JSONObject obj = new JSONObject();
    List<Serializable> list = null;
    for (int i = 0; i < node.size(); i++) {
      list = new LinkedList<Serializable>();
      et = (Element) node.get(i);
      if (et.getTextTrim().equals("")) {
        if (et.getChildren().size() == 0)
          continue;
        if (obj.containsKey(et.getName())) {
          list = (List) obj.get(et.getName());
        }
        list.add(iterateElement(et));
        obj.put(et.getName(), list);
      } else {
        if (obj.containsKey(et.getName())) {
          list = (List) obj.get(et.getName());
        }
        list.add(et.getTextTrim());
        obj.put(et.getName(), list);
      }
    }
    return obj;
  }
  
  /**
   * 
   * 
   <?xml version="1.0" encoding="utf-8" ?>
  <MoBaoAccount MessageType="UserMobilePay" PlatformID="b2ctest">
  <OrderNo>M20150521084825</OrderNo>
  <TradeAmt>5000.00</TradeAmt>
  <Commission>0.5</Commission>
  <UserID>xiaolong</UserID>
  <MerchID>xiaolong1</MerchID>
  <tradeType>0</tradeType>
  <CustParam>123</CustParam>
  <NotifyUrl>http://mobaopay.com/callback.do</NotifyUrl>
  <TradeSummary>订单</TradeSummary>
  </MoBaoAccount>

   * @param args
   * @throws JDOMException
   * @throws IOException
   */
  public static void main(String[] args) throws JDOMException, IOException {
    String xml="<?xml version=\"1.0\" encoding=\"utf-8\" ?><MoBaoAccount MessageType=\"UserMobilePay\" PlatformID=\"b2ctest\"><OrderNo>M20150521084825</OrderNo><TradeAmt>5000.00</TradeAmt><Commission>0.5</Commission><UserID>zhuxiaolong</UserID><MerchID>zhuxiaolong1</MerchID><tradeType>0</tradeType><CustParam>123</CustParam> <NotifyUrl>http://mobaopay.com/callback.do</NotifyUrl><TradeSummary>订单</TradeSummary></MoBaoAccount>";
    JSONObject json=xml2JSON(xml.getBytes());
    System.out.println(json.toJSONString());
  }
}

