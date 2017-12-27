package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.management.Attribute;

public class MyDefaultHandler2 extends DefaultHandler {
    // 存储xml 文本信息
    private StringBuffer sb = new StringBuffer();

    public String getContent() {
        return this.sb.toString();
    }

    // 开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        sb.append("<"+qName);
        // 属性列表
        if(attributes != null){
            // 遍历属性
            for (int i=0;i<attributes.getLength();i++){
                String name = attributes.getQName(i);   // 属性名称
                String value = attributes.getValue(i);  // 属性值
                sb.append(" "+name+"=\""+value+" \"");
            }
        }
        sb.append(">");
    }

    // 文本内容
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //当前文本内容
        String content = new String(ch,start,length);
        sb.append(content);
    }

    // 结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        sb.append("</"+qName+">");
    }

}
