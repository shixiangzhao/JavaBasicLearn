package shixzh.jbl.nio;

import java.io.*;

public class InputStreamReadByte {

    public static void main(String[] args) throws IOException {
        String path1 = "test.txt";
        //String path2 = File.separator + "home" + File.separator + "shixzh" + File.separator + "test.txt";
        //System.out.println(path2);
        File file = new File(path1);
        InputStream inputStream = null; // after read byte 
        InputStream inputStream1 = null; // init value
        try {
            inputStream = new FileInputStream(file);
            inputStream1 = new FileInputStream(file);
            System.out.println("inputStream value before read(b): ");
            printStream(inputStream1);
            System.out.println("inputStream available byte count: " + inputStream.available());
            byte[] b = {'a', 'c' , 'b'};
            System.out.println("byte[] value before read(b): ");
            printByte(b);
            //before inputStream.read(b): b = {'a', 'c', 'b'}; inputStream = "i love programming";
            System.out.println("read byte into input stream: " + inputStream.read(b));
            //after inputStream.read(b): b = {'i', ' ', 'l'}; inputStream = "ove programming";
            System.out.println("byte[] value after read(b): ");
            printByte(b);
            System.out.println("inputStream value after read(b): ");
            printStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            inputStream1.close();
        }
    }

    public static void printStream(InputStream inputStream) throws IOException {
        int tempbyte;
        while((tempbyte = inputStream.read()) != -1){
            System.out.write(tempbyte);
            //System.out.println(" => " + tempbyte);
        }
    }

    public static void printByte(byte[] b){
        for ( int i = 0; i < b.length; i++ ) {
            System.out.print(b[i] + ", ");
        }
        System.out.println();
    }
}
