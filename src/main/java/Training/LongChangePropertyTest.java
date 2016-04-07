package Training;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class LongChangePropertyTest {
    public static void main(String[] args) throws InterruptedException {
        //from: http://www.java2s.com/Code/Java/JavaFX/ChangeListenerforIntegerProperty.htm
        final LongProperty longPropertyDatabaseChanged = new SimpleLongProperty();
        //longPropertyDatabaseChanged.set(System.currentTimeMillis());
        final ChangeListener changeListenerDatabase = new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //System.out.println("oldValue:"+ oldValue + ", newValue = " + newValue);
                System.out.println("longProperty has changed, new value = " + longPropertyDatabaseChanged);
            }
        };
        longPropertyDatabaseChanged.addListener(changeListenerDatabase);




        for(int i=0;i<10;i++){
            Thread.sleep(100);
            longPropertyDatabaseChanged.setValue(System.currentTimeMillis());
        }



    }
}