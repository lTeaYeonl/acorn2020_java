package example1;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientMain {
   public static void main(String[] args) {
      Socket socket=null;
      try {
         socket=new Socket("192.168.0.19", 5000);
         System.out.println("Socket 연결 성공!");
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         try {
            if(socket!=null)socket.close();
         } catch (Exception e) {}
      }
      System.out.println("main 메소드가 종료됩니다.");
   }
}