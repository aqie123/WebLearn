一：网络通信 Socket编程
    1. 输入流：
        输入字节流 InputStream
                        FileInputStream
                        BufferedInputStream
                    方法：
                        read() 读取一个字节
                        read(byte[] data) 读取多个字节
                    结束：返回长度-1
        输入字符流 Reader
                        FileReader
                        BufferedReader
                    方法：
                        read() 读取一个字符
                        read(char[] data) 读取多个字符
    2. 服务器 DemoServer
    3. 常用的 Web服务器
        1. WebSphere   IBM 收费 支持javaEE规范
        2. IIS  微软   收费  .net
        3. WebLogic  BEA  收费
        4. Tomcat
二：Servlet extends HttpServlet类(导入tomcat服务器)
    1.http://localhost:8080/servlet/
    2.配置 web.xml 访问自定义 servlet
        a.http://localhost:8080/servlet/hello
        b.servlet对应的class文件拷贝到tomcat某个项目中(servlet/WEB-INF/classes)
         记得拷贝包名 myServlet/DemoServlet.class
    3.intellij 新建servlet
        (http://blog.csdn.net/yhao2014/article/details/45740111)