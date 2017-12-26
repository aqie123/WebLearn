package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * sax 解析事件处理程序(类似于事件监听器)
 */
public class MyDefaultHandler1 extends DefaultHandler{
    /**
     * 遇到xml文档开始位置触发此方法
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.startDocument()->");
    }

    /**
     *
     遇到每个开始标签触发此方法
     qName 当前读到的开始标签名称
     属性列表
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("MyDefaultHandler1.startElement()->"+qName);
    }
    /**
     * 遇到结束标签触发以下方法
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("MyDefaultHandler1.endElement()->"+qName);
    }
    /**
     *遇到文本触发此内容
     * ch: 表示到目前为止读到的文本内容
     * start: 当前内容起始位置
     * length: 当前内容长度
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 获取当前读到的内容
        String content = new String(ch,start,length);
        System.out.println("MyDefaultHandler1.characters()->"+content);
    }

    /**
     * 遇到xml文档结尾
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        System.out.println("MyDefaultHandler1.endDocument()->");
    }
}
