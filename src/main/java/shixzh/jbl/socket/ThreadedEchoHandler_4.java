package shixzh.jbl.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler_4 implements Runnable {

    private Socket incoming;

    public ThreadedEchoHandler_4(Socket s) {
        this.incoming = s;
    }

    @Override
    public void run() {
        try {
            boolean isClose = false;
            while (!isClose) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(outStream, true/* autoFlush */);
                    out.println("Hello! Enter BYE to exit.");
                    while (!isClose && in.hasNextLine()) {
                        String line = in.nextLine();
                        System.out.println("Client say: " + line);
                        if (line.trim().equals("BYE")) {
                            isClose = true;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
