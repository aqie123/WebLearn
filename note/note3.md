一：HTTP协议
二：Telnet
    1. telnet localhost  8080   退出 ctrl+] 然后回车
    2,发送请求
        GET /first HTTP/1.1
Host: localhost:8080
    3. 访问路径
        1.D:\coreJava\myServlet\firstweb  在myServlet目录下
        2.http://localhost:8080/first/
 三：curl请求
    1. curl http://localhost:8080/first/