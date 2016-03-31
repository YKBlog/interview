package network.socket.singleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端
 * 
 * @Title: SocketServer.java
 * @Description: <br>
 * <br>
 * @Company: 美丽说
 * @Created on 2016年3月10日 下午4:15:14
 * @author yangkai
 * @version 1.0
 */
public class SocketServer {

    public static void accept(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) { // 循环保持监听客户端信息
                Socket socket = serverSocket.accept(); // 每个请求都会产生一个socket
                /**
                 * 获取客户端信息
                 */
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String result = bufferedReader.readLine();
                System.out.println("client say:" + result);

                /**
                 * 服务端向客户端消息
                 */
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.print("hello client,i'm server");
                printWriter.flush();

                // 关闭资源
                printWriter.close();
                bufferedReader.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        accept(3333);
    }
}
