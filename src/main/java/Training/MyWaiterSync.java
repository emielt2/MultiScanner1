package Training;

/**
 * Created by E on 02/04/2016.
 */
public class MyWaiterSync {
    public static void main(String args[]) {
        new MyWaiterSync().sleepX(1000);
    }

    synchronized void sleepX(int x) {
        try {
            //wait();
            x += Math.random() * 2000;
            System.out.println("Sleep " + x + "millisecs");

            Thread.sleep(x);
            //notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
