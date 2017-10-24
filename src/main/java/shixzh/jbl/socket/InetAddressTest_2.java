package shixzh.jbl.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest_2 {

    public static void main(String[] args) throws UnknownHostException {
        if(args.length > 0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
            // cnpc1864/10.157.47.103
        }
    }
}
