import java.util.*;


public class IP2IntAndInt2IP {

    public static void main(String[] args) {

        long i = IPv4ToInt("1.1.1.1");
        System.out.println(i);
        String s = Int2IP(16843009);
        System.out.println(s);
    }

    private static String Int2IP(int ipInt) {
        int mask = 255;
        String[] ipItems = new String[4];
        for (int i = 0; i < 4; i++) {
            ipItems[3-i] = String.valueOf((ipInt & mask) >> (i * 8));
            mask = mask << 8 | mask;
        }
        return String.join(".", ipItems);
    }


    private static long IPv4ToInt(String IP) {
        String[] ipItems  = IP.split("\\.");
        long re = 0;
        for(int i = 0; i < ipItems.length; i++) {
            String ipItem = ipItems[i];
            long ii = Long.parseLong(ipItem);
            re = re << 8 | ii;
        }
        return re;
    }

}

}
