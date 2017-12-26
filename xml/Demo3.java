package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.List;

public class Demo3 {
    public static void main(String[] args) throws DocumentException, IOException {
        Test3 t = new Test3();
        // t.method();
        // t.method2();
        t.method3();
    }
}

class Test3{
    // 删除id=002的contact   dom4j
    void method() throws DocumentException, IOException {
        Document doc = readXml();
        List<Element> conList = doc.getRootElement().elements("contact");
        for (Element e:conList
             ) {
            if(e.attributeValue("id").equals("002")){
                e.detach();
                System.out.println("删除成功");
                break;
            }
        }
        modifyXml(doc);

    }

    private void modifyXml(Document doc) throws IOException {
        // 修改后的document写出到硬盘
        OutputStream out = new FileOutputStream("xml/xmlFiles/AddressBook2.xml");
        OutputFormat format = new OutputFormat();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(out,format);
        writer.write(doc);
        writer.close();
    }

    // 删除id=002的contact   xPath
    void method2() throws DocumentException, IOException {
        Document doc = readXml();
        // 查询id为002的contact 标签
        Element conElem = (Element) doc.selectSingleNode("//contact[@id='002']");
        conElem.detach();
        modifyXml(doc);
    }

    private Document readXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(new File("xml/xmlFiles/AddressBook2.xml"));
    }

    //  查询xml文件
    void method3() throws DocumentException, IOException {
        Document doc = readXml();
        String xpath = "";
        xpath = "/contact-list";
        xpath = "/contact-list/contact";
        xpath = "//contact";
        xpath = "//contact/name";
        xpath = "//contact/*";
        xpath = "//contact-list//*"; // 所有后代标签,不分层次
        xpath = "//contact[1]"; // 第一个标签
        xpath = "//contact[last()]"; // 最后一个标签
        xpath = "//@id"; // 选择所有id属性
        xpath = "//contact[@id]"; // 选择所有包含id属性的contact标签
        xpath = "//contact[@id='002' and @name='def']"; // 选择所有包含id属性的contact标签
        xpath = "//name[1]/text()"; // 选择文本
        xpath = "//name[text() = 'aqie456']"; // 选择文本内容为aqie456的标签


        List<Node> list = doc.selectNodes(xpath);
        for(Node node : list){
            System.out.println(node);
        }
    }
}
