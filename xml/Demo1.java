package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) throws DocumentException {
        Test1 t = new Test1();
        t.method();
    }
}
class Test1{
    void method() throws DocumentException {
        // 1.读取xml文件
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("xml/xmlFiles/AddressBook.xml"));

        // 2.创建list对象
        List<AddressBook> list = new ArrayList();
        // 3.xml信息->list对象
        List<Element> conList = doc.getRootElement().elements("contact"); // 获取所有contact标签
        for (Element elem:conList
             ) {
            // 创建 AddressBook对象中
            AddressBook addressBook = new AddressBook();
            addressBook.setId(elem.attributeValue("id"));
            addressBook.setName(elem.elementText("name"));
            addressBook.setMobile(elem.elementText("mobile"));
            // 保存数据，AddressBook对象放入list对象
            list.add(addressBook);
        }
        // 5.输出
        for (AddressBook ab:list){
            System.out.println(ab);
        }
    }
}
