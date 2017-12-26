package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class Demo4 {
    public static void main(String[] args) throws IOException, DocumentException {
        Test4 t = new Test4();
        // t.createXml();
        while (true){
            t.mokeLogin();
        }
    }
}
class Test4{
    // 1.新建空xml文件
    public void createXml()throws DocumentException, IOException {
        Document doc = DocumentHelper.createDocument();
        // 添加元素
        Element conListElem = doc.addElement("user-list");
        addContent(conListElem);
        addContent(conListElem);

        modifyXml(doc);
        writeToXml(doc);

    }

    public void mokeLogin() throws IOException, DocumentException {
        // 获取用户输入用户名和密码
        // System.in字节流 BufferedReader字符流 需要转换流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入用户名");
        String name = bufferedReader.readLine();
        String pwd;


        // 在xml数据库查找 name=aqie password=123
        Document doc = readXml();
        // 查找文本为name的name标签
        Element nameElem = (Element) doc.selectSingleNode("//user/name[text()='"+name+"']");
        //Element pwdnElem = (Element) doc.selectSingleNode("//user/password[text()='"+pwd+"']");

        // 判断name标签是否存在
        if(nameElem != null){
            // 判断密码是否正确
            // 获取到父类标签
            Element userElem = nameElem.getParent();
            System.out.println("请输入密码");
             pwd = bufferedReader.readLine();
            // 判断password子标签文本内容
            String dbpwd = userElem.elementText("password");
            // 用户输入密码和数据库密码一致
            if(pwd.equals(dbpwd)){
                System.out.println("登录成功");
                System.exit(0);
            }else{
                System.out.println("密码错误");
            }
        }else{
            System.out.println("该用户名不存在");
        }
    }

    private void modifyXml(Document doc) {
        String xpath = "";
        xpath = "//user[2]/name[1]";
        String xpath2 = "//user[2]/password[1]";
        Element nameElem = (Element) doc.selectSingleNode(xpath);
        Element pwdElem = (Element) doc.selectSingleNode(xpath2);
        nameElem.setText("啊切");
        pwdElem.setText("456");
    }

    private void writeToXml(Document doc) throws IOException {
        OutputStream outputStream = new FileOutputStream("xml/outPutFiles/b.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        format.setEncoding("utf-8");
        XMLWriter writer = new XMLWriter(outputStream,format);
        writer.write(doc);
    }

    // 给xml添加内容
    private void addContent(Element conListElem) {
        Element userElem = conListElem.addElement("user");
        Element nameElem = userElem.addElement("name");
        Element pwdElem = userElem.addElement("password");
        // 添加属性
        conListElem.addAttribute("id","001");
        // 给元素赋值
        nameElem.setText("aqie");
        pwdElem.setText("123");
    }

    // 创建xml读取对象
    private Document readXml() throws DocumentException {
        SAXReader reader = new SAXReader();
        return reader.read(new File("xml/outPutFiles/b.xml"));
    }
}
