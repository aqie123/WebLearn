package xml;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

// 利用dom4j读取xml文件
public class Demo {
    public static void main(String[] args) throws DocumentException {
        Test t = new Test();
        // t.method();
        // t.method2();
        // t.method3();
        t.method4();


    }
}
class Test{
    // 1.创建xml解析器对象
    SAXReader reader = new SAXReader();
    // 2.读取xml文件
    // Document doc = reader.read(new File("D:\\coreJava\\WebLearn\\xml\\xmlFiles\\AddressBook.xml"));
    Document doc = reader.read(new File("xml/xmlFiles/AddressBook.xml"));
    // 3.读取根标签
    Element rootElem = doc.getRootElement();// (对象)
    Test() throws DocumentException {
    }

    void method() throws DocumentException {
        System.out.println(doc); // (对象)
        System.out.println(rootElem);
        // 4. 读取根标签名称
        System.out.println(rootElem.getName());
        // 5.根据指定名称获取第一个子标签
        Element sonElem = rootElem.element("contact");// (对象)
        System.out.println(sonElem);
        // 6.根据指定名称获取所有子标签
        List<Element> list = rootElem.elements("contact");
        // 遍历List 方式一
        /*for(int i = 0;i<list.size();i++){
            System.out.println(list.get(i).getName());
        }*/

        // 遍历方式二
        /*for(Element e : list){
            System.out.println(e.getName());
        }*/

        // 遍历方式三 迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("====获取所有子标签，不指定名称=====");
        List<Element> elems = rootElem.elements();
        for (Element elem: elems
             ) {
            System.out.println(elem.getName());
        }
    }

    // 获取相对路径
    void method1(){
        File file = new File("");
        System.out.println(file.getAbsolutePath());
//        System.out.println(System.getProperty("."));
    }

    // 获取孙标签 先拿到子标签再获取孙标签
    void method2(){
        // 获取第一个孙标签
        Element element = rootElem.element("contact").element("name");
        System.out.println(element.getText());

        List<Element> list = rootElem.element("contact").elements();
        for (Element e:list
             ) {
            System.out.println(e.getText());
        }
    }

    // 获取xml属性信息
    void method3(){
        Element conElem = rootElem.element("contact");
        // 标签上获取属性
        System.out.println(conElem.attributeValue("id"));
        // 获取第二个属性的id 方式一：(根据属性名称获取对应属性值)
        Element conElem2 = (Element) rootElem.elements().get(1);
        System.out.println(conElem2.attributeValue("id"));
        // 方式二(根据属性名称获取属性对象)
        Element conElem3 = rootElem.element("contact");
        Attribute idAttr = conElem3.attribute("id");        // 对象
        System.out.println(idAttr);
        // 属性名
        String idName = idAttr.getName();
        // 属性值
        String idValue = idAttr.getValue();
        System.out.println(idName + " = "+idValue);

        // 方式三 获取标签所有属性
        System.out.println("方式三 获取标签所有属性");
        Element conElem4 = rootElem.element("contact");
        List<Attribute> list = conElem4.attributes();
        for(Attribute e : list){
            System.out.println(e.getValue()+"="+e.getName());
        }

    }

    // 获取xml的文本信息
    void method4(){
        Element conElem = rootElem.element("contact");
        // 1.拿到所在标签上文本内容
        Element nameEle = conElem.element("name");
        System.out.println(nameEle.getText());
        // 2. 通过父标签获取指定子标签的文本内容
        System.out.println(conElem.elementText("name"));
    }
}
