package network.socket.singleClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
/**
 * socket客户端
 * @Title: SocketClient.java
 * @Description: <br>
 *               <br>
 * @Company: 美丽说
 * @Created on 2016年3月10日 下午4:15:01
 * @author yangkai
 * @version 1.0
 */
public class SocketClient {

    public static void send(String ip, int port) {
        try {
            Socket socket = new Socket(ip, port);
            socket.setSoTimeout(6000);// 超时时间60s
            /**
             * 客户端向服务端发送信息
             */
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true); // 通过socket获取输出流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // 将输入流输出到server
            printWriter.println(bufferedReader.readLine());
            printWriter.flush();

            /**
             * 获取服务端信息
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 通过socket得到输入流
            String result = br.readLine();
            System.out.println("server say:" + result);

            // 关闭资源
            printWriter.close();
            bufferedReader.close();
            br.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        send("127.0.0.1", 3333);
    }
}
