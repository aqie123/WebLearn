package xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo5 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Test5 t = new Test5();
        // t.method();
        // t.method2();
        t.method3();
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

    // sax 解析方式读取AddressBook3,原封不动打印
    void method2() throws ParserConfigurationException, SAXException, IOException {
        // 1.创建SAXParser对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        // 2.解析xml文件
        File file = new File("D:\\coreJava\\WebLearn\\xml\\xmlFiles\\AddressBook3.xml");
        // 创建事件处理程序
        MyDefaultHandler2 handler2 = new MyDefaultHandler2();
        parser.parse(file,new MyDefaultHandler2());
        System.out.println(handler2.getContent());

    }

    // sax解析把AddressBook3.xml文件信息封装成List对象
    void method3() throws ParserConfigurationException, SAXException, IOException {
        // 1.创建SAXParser对象
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        // 2.解析xml文件
        File file = new File("D:\\coreJava\\WebLearn\\xml\\xmlFiles\\AddressBook4.xml");
        // 创建事件处理程序
        MyDefaultHandler3 handler3 = new MyDefaultHandler3();
        parser.parse(file,handler3);

        // 获取封装好的list对象
        List<AddressBook> conList = handler3.getConList();
        for(AddressBook ab:conList){
            System.out.println(ab);
        }
    }
}
