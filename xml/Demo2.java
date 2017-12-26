package xml;

import jdk.internal.util.xml.XMLStreamException;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class Demo2 {
    public static void main(String[] args) throws IOException, XMLStreamException, DocumentException {
        Test2 t = new Test2();
        // t.method();
        // t.method2();
        //t.method3();
        t.method4();
    }
}
class Test2{
    // 复制写出一个xml文件
    void method() throws IOException, XMLStreamException, DocumentException {
        /**
         * 输出流
         *  字符输出流 Writer->FileWriter/BufferedWriter
         *      方法 write(char c) 写出一个字符
         *           write(char[] data) 写出多个字符
         *           write(String str)写出字符串toCharArray
         *  字节输出流 OutputStream->FileOutputStream/BufferedOutputStream/ObjectOutputStream
         *      方法 write(byte):写出一个字节
         *          write(byte[] data) 写出多个字节
         */
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("xml/xmlFiles/AddressBook.xml"));
        // 创建输出字符流
        File file = new File("xml/myXml.xml");
        // file.createNewFile();  file.exists()
        OutputStream outputStream = new FileOutputStream(file);
        // 创建输出对象
        XMLWriter writer = new XMLWriter(outputStream);
        writer.write(doc);
    }

    // 修改xml文件
    void method2() throws IOException, DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("xml/xmlFiles/AddressBook.xml"));
        // 创建输出流
        OutputStream outputStream = new FileOutputStream("xml/outPutFiles/AddressBook.xml");
        // 设置输出格式
        //OutputFormat format = OutputFormat.createCompactFormat(); // 紧凑的格式
        OutputFormat format = OutputFormat.createPrettyPrint();     // 漂亮的格式
        // 设置输出的编码格式(1.xml文档encoding编码 2.xml内容保存编码)
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream,format);
        writer.write(doc);
    }

    // 修改xml文档 添加属性
    void method3() throws IOException {
        // 添加空文档
        Document doc = DocumentHelper.createDocument();
        // 添加标签
        Element conListElem = doc.addElement("contact-list");
        Element conElem = conListElem.addElement("contact");
        conElem.addElement("name");
        // 添加属性
        conElem.addAttribute("id","001");
        conElem.addAttribute("name","aqie");


        // 把文档写出到xml文件中
        OutputStream outputStream = new FileOutputStream("xml/outPutFiles/a.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream,format);
        writer.write(doc);
    }

    void method4() throws IOException, DocumentException {
        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("xml/outPutFiles/a.xml"));

        Element conListElem = doc.getRootElement();
        Element conElem = conListElem.element("contact");
        // 1.得到属性对象，调用方法修改属性值
        Attribute idAttr = conElem.attribute("id");
        /*idAttr.setValue("003");*/
        // 2.标签中添加同名属性，覆盖属性值
        conElem.addAttribute("id","004");
        // 3.修改文本
        Element nameElem = conElem.element("name");
        // nameElem.setText("啊切");
        // 4. 删除标签
        //nameElem.detach();
        // nameElem.getParent().remove(nameElem);
        // 5.删除属性
        idAttr.detach();


        OutputStream outputStream = new FileOutputStream("xml/outPutFiles/a.xml");
        OutputFormat  format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream,format);

        writer.write(doc);

    }
}
