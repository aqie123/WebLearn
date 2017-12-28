一：搭建tomcat
    1.下载
    2. 搭建tomcat (https://www.cnblogs.com/puresoul/p/4234742.html)
           1. 下载
           2, 启动
                1. 双击startup.bat  shutdown.bat 关闭tomcat
                2.  添加环境变量 %CATALINA_HOME%\bin;
                    添加环境变量 CATALINA_HOME = D:\Program Files\apache-tomcat-8.5.24
                    此时在另一个窗口打开Tomcat
                    1. 命令行输入catalina run就可看到在当前窗口启动了tomcat：
                 3. 开机自启动
                    1. service.bat install Tomcat
                       service.bat remove Tomcat
                    2. 服务中开启
           3.查看是否启动 net start 
           4. 修改Tomcat服务器端口
                server.xml文件，修改配置文件中的Connector节点的port属性
           5. 管理虚拟站点 conf/tomcat-users.xml
二：Tomcat
    1. http://192.168.88.1:8080/web/hello.html
    2. http://192.168.88.1:8080/test/a.jpg
    3.多站点部署
        1.一个tomcat想部署两个web工程，说白了就是公用一个端口
    4.虚拟主机实现方式
        a.基于主机名的虚拟主机：多个域名解析到同一个IP地址
            name -- 指定虚拟主机的名称,浏览器通过这个名称访问虚拟主机
            appBase -- 虚拟主机管理的目录,放置在这个目录下的web应用当前虚拟主机
            可以自动加载
        b.基于端口号的虚拟主机：一个IP地址，通过不同的端口实现不同网站的访问
        c.(http://blog.csdn.net/jintaohahahaha/article/details/50210439)
            1.http://localhost:8080/web2/
            2.D:\Program Files\apache-tomcat-8.5.24\mywebapp(实际路径)
            注意：path可以不写内容,默认网站优先级高于ROOT
                  修改server.xml文件,风险较大
        d.通过添加xml配置虚拟网站
            (http://blog.csdn.net/ful1021/article/details/45130247)
            1.http://localhost:8080/server2/   访问
             实际路径 E:\Tomcat\server2
             D:\Program Files\apache-tomcat-8.5.24\conf\Catalina\localhost添加server2.xml
        e.直接将web应用放置到虚拟主机管理的目录
    5. 站点设置 host(一个站点可以包含多个网站)
        http://www.aqiejava.com:8080/zhidao/
        1.name : 访问站点就是使用站点名称
        2.appBases: 站点根目录
        3.步骤：(E:\aqiejava)
            1.server.xml添加host标签
            2.新建站点
三：网站目录
    1.WebRoot 根目录
        |-普通文件 (html css js images)
        |-WEB-INF   (目录固定写法)
            |-classes   (目录固定写法 存放class文件)
            |-lib       (目录，固定写法 存放jar包)
            |-web.xml   文件
    2. WEB-INF 外部文件可直接通过浏览器访问,
        里面内容如果提供外部访问，需要在xml文件中配置
    3.