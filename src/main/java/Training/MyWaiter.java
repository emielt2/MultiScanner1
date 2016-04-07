package Training;

/**
 * Created by E on 30/03/2016.
 */
public class MyWaiter {
    public static void main(String[] args) {
        System.out.println("STaRTEd");
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
            //new SleeperX().sleepX(100);
            SleeperX s1=new SleeperX(300,i);
            //Thread t1 = new Thread(new SleeperX(300, i));
            Thread t1 = new Thread(s1);
            t1.start();
            t1.getName();
        }
    }


}

class SleeperX implements Runnable {
    int timex;
    int number;
    private static int plusmin =0;
    public SleeperX(int timex, int number) {
        this.timex = timex;
        this.number = number;
    }

    synchronized void sleepX(int x) {
        try {
            plusmin++;
            //wait();
            //x += Math.random() * 2000;
            //System.out.println("Sleep " + x + "millisecs" + "on thread: " + number);
            //System.out.println("plusmin++ " + plusmin);

            Thread.sleep(x);
            //notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void sleepY(int y) {
        try {
            plusmin--;
            //wait();
            //y += Math.random() * 2000;
            //System.out.println("Sleep " + y + "millisecs" + "on thread: " + number);
            //System.out.println("plusmin-- " + plusmin);

            Thread.sleep(y);
            //notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            sleepY(timex);
            sleepX(timex);

            System.out.println("plusmin " + plusmin);
        }
    }
}
