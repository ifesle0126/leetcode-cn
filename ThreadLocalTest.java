import java.util.*;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> tl = new ThreadLocal<>();
    
    public static void main(String[] args) throws Exception {

        Thread t1 = new Thread(new Runnable(){
            int i1 = 1;
            @Override
            public void run() {
                try {
                    int times = 10;
                    while (times-- > 0) {
                        i1++;
                        Thread.sleep(100);
                    }
                } catch (Exception e) {

                }
                tl.set(i1);
                System.out.println(tl.get());
            }
        });

        Thread t2 = new Thread(new Runnable(){
            int i2 = 1;
            @Override
            public void run() {
                try {
                    int times = 20;
                    while (times-- > 0) {
                        i2++;
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                        
                }
                tl.set(i2);
                System.out.println(tl.get());
            }
        });

        t1.start();
        t2.start();
        

        t1.join();
        t2.join();
        Integer i = tl.get();
        System.out.println(i);
    }


}