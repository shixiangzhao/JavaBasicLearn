package shixzh.jbl.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {

    public static void main(String[] args) {
        boolean isClose = false;
        while (!isClose) {
            try (Socket s = new Socket("localhost", 8189)) {
                //s.setSoTimeout(10000);
                BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String acceptStr = input.readLine();
                System.out.println("Server say: " + acceptStr);
                PrintStream out = new PrintStream(s.getOutputStream());
                System.out.println("Enter: ");
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
                out.println(str);
                if("BYE".equals(str)) {
                    isClose = true;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
