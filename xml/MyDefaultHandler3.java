package xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyDefaultHandler3 extends DefaultHandler {
    // 用于存储所有的 AddressBook信息
    private List<AddressBook> conList = new ArrayList<>();
    // 用于存储一个contact标签中的信息
    private AddressBook addressBook = null;

    // 用于记录当前标签
    private String currTag;

    public List<AddressBook> getConList() {
        return conList;
    }

    /**
     * 1.创建新的AddressBook对象,封装AddressBook标签
     * 2.把当前读到的AddressBook标签的信息封装到AddressBook对象中
     * 3.封装好的Contact对象放入List中
     */

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("contact")){
            // 创建AddressBook对象
            addressBook = new AddressBook();
            currTag = qName;
            // 封装id属性
            String id = attributes.getValue("id");
            addressBook.setId(id);
            String name = attributes.getValue("name");
            addressBook.setName(name);
        }
    }

    // 文本内容(包含换行和空格)
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 子标签文本内容封装到 addressBook中
        String content = new String(ch,start,length);
        // 当前标签是name
        if("name".equals(currTag)){
            addressBook.setName(content);
        }
        if("mobile".equals(currTag)){
            addressBook.setMobile(content);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currTag = null;
        // 遇到contact结束标签时,将Contact放入到List中
        if(qName.equals("contact")){
            conList.add(addressBook);
        }
    }
}
