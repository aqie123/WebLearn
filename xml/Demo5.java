package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Demo5 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Test5 t = new Test5();
        t.method();
    }
}
class Test5{
    void method() throws ParserConfigurationException, SAXException, IOException {
        // 创建 SAXParser解析对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        // 解析xml文件
        /**
         * 参数：需要解析的xml文件,指定的DefaultHandler
         */
        // 注册监听器
        File file = new File("D:\\coreJava\\WebLearn\\xml\\xmlFiles\\AddressBook3.xml");
        parser.parse(file,new MyDefaultHandler1());
    }
}
