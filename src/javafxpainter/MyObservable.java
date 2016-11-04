package javafxpainter;

import java.util.Observable;

public class MyObservable extends Observable {

    public static MyObservable INST = new MyObservable();

    public void changed() {
        setChanged();
        notifyObservers();
    }

}
