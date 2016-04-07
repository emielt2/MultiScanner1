/**
 * Created by E on 25/03/2016.
 */
public class SleepRandom implements Runnable {
    SleepRandom(){}
    @Override
    public void run() {

    }

    int SleepX(){
        System.out.println(""+Math.random());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 1;
    }

}
