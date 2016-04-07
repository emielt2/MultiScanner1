package Training;

/**
 * Created by E on 02/04/2016.
 */

public class Interthreadcon {
    public static void main(String[] args) {
        try {
            product s = new product();
            System.out.println("Check1");
            Thread.sleep(5000);
            new producer(s);

            Thread.sleep(1000);

            System.out.println("Check2");
            Thread.sleep(5000);

            new consumer(s);

            System.out.println("Check3");
            Thread.sleep(5000);
        } catch (Exception e) {

        }
    }
}

class product {
    int contents = 0;
    boolean available = false;

    synchronized int get() {
        if (available == false)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptException caught");
            }

        System.out.println("consume:" + contents);
        System.out.println("hello");
        available = false;
        notifyAll();
        return contents;
    }

    synchronized void put(int num) {
        if (available == true)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException caught");
            }
        contents = num;
        System.out.println("produce:" + contents);
        System.out.println("Welcome");
        notifyAll();
    }
}

class producer extends Thread {
    product p;

    producer(product p) {
        this.p = p;
        this.start();
    }

    public void run() {
        int i = 0;
        p.put(++i);
    }
}

class consumer extends Thread {
    product p;

    consumer(product p) {
        this.p = p;
        this.start();
    }

    public void run() {
        p.get();
    }
}
