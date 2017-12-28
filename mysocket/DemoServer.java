package mysocket;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
    public static void main(String[] args) throws IOException {
        Test t = new Test();
        t.method();
    }
}
class Test{
    void method() throws IOException {
        // 1.创建serverSocket对象 监听端口
        ServerSocket serverSocket = new ServerSocket(9000);
        System.out.println("Server is starting!");
        while(true){
            // 2.接收客户端连接
            Socket socket = serverSocket.accept();
            // 3.本地hello.html发送给socket客户端
            // 3.1 构建数据发送通道
            OutputStream outputStream = socket.getOutputStream();
            // 3.2 读取本地文件内容
            FileInputStream fileInputStream = new FileInputStream("static/html/hello.html");
            // 3.3 边读边写
            /*int length = 0;
            while((length = fileInputStream.read()) != -1){
                outputStream.write(length);
            }*/
            // 字节数组
            byte[] buff = new byte[1024];
            int length = 0;
            while((length = fileInputStream.read(buff)) != -1){
                outputStream.write(buff,0,length);
            }
            fileInputStream.close();
            outputStream.close();
        }
    }
}
