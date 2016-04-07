package Training;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class IntegerPropertyChangedTest {
    public static void main(String[] args) {
        IntegerProperty intProperty = new SimpleIntegerProperty(1024);
        final ChangeListener changeListener = new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue,
                                Object newValue) {
                System.out.println("oldValue:"+ oldValue + ", newValue = " + newValue);
            }
        };

        intProperty.addListener(changeListener);
        intProperty.set(5120);

        intProperty.removeListener(changeListener);

        intProperty.set(6144);
    }
}
