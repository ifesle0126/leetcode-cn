import java.util.concurrent.locks.*;


/**
 * 三个线程交替打印 A B C 三个字符
 * 
 * 
 */

public class three_thread_loop_printABC implements Runnable{

    private final String world;
    private final Lock lock;
    private final Condition self;
    private final Condition next;


    public three_thread_loop_printABC(String world, Lock lock, Condition self, Condition next) {
        this.world = world;
        this.lock = lock;
        this.self = self;
        this.next = next;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + ": " + world);
                next.signal();
                if (i < 9) {
                    self.await();
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

	public static void main(String[] args) throws Exception {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();

        Thread t_a = new Thread(new three_thread_loop_printABC("A", lock, A, B));
        Thread t_b = new Thread(new three_thread_loop_printABC("B", lock, B, C));
        Thread t_c = new Thread(new three_thread_loop_printABC("C", lock, C, A));

        t_a.start();Thread.sleep(10);
        t_b.start();Thread.sleep(10);
        t_c.start();Thread.sleep(10);

	}
}