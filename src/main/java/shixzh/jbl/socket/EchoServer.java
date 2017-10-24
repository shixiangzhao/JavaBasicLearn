package shixzh.jbl.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try (ServerSocket s = new ServerSocket(8189);) {
            System.out.println(new Date() + ", Create a SERVER SOCKET, which size: " + s.getReceiveBufferSize());
            try (Socket incoming = s.accept()) {
                System.out.println(new Date() + ", Accept one SOCKET from: " + incoming.getInetAddress());
                InputStream in = incoming.getInputStream();
                System.out.println(new Date() + ", SOCKET input stream: " + in.toString());
                OutputStream out = incoming.getOutputStream();
                System.out.println(new Date() + ", SOCKET output stream: " + out.toString());
                try (Scanner ins = new Scanner(in)) {
                    System.out.println(new Date() + ", SOCKET scanner: " + ins.toString());
                    PrintWriter pw = new PrintWriter(out, true);
                    System.out.println(new Date() + ", SOCKET print writer: " + pw.toString());
                    pw.println("Hello! Enter BYE to exit:");

                    boolean done = false;
                    System.out.println(new Date() + ", Is SOCKET scanner has next line: " + ins.hasNextLine());
                    while (done != true && ins.hasNextLine()) {
                        String line = ins.nextLine();
                        pw.println("Echo: " + line);
                        if ("BYE".equals(line)) {
                            done = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
