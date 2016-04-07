package Training;

/**
 * Created by E on 02/04/2016.
 */
// A correct implementation of a producer and consumer.
class Q {
    int n;
    boolean valueSet = false;
    synchronized int get() {
        if(!valueSet)
            try {
                wait();
                //Thread.sleep(100);//SLAAPT NIET, MAAR WACHT WEL NETJES
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        System.out.println("Got: " + n);
        System.out.println("---------------------");
        valueSet = false;

        notify();
        return n;
    }
    synchronized void put(int n) {
        if(valueSet)
            try {
                Thread.sleep(1000);
                wait();
            } catch(InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        this.n = n;
        valueSet = true;
        System.out.println("Put: " + n);
        notify();
    }
}

class Producer implements Runnable {
    Q q;
    Producer(Q q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
    public void run() {
        int i = 0;
        while(true) {
            q.put(i++);
        }
    }
}

class Consumer implements Runnable {
    Q q;
    Consumer(Q q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
    public void run() {
        while(true) {
            q.get();
        }
    }
}

class PCFixed {
    public static void main(String args[]) {
        Q q = new Q();
        new Consumer(q);
        new Producer(q);
        System.out.println("Press Control-C to stop.");
    }
}
