import java.util.HashMap;

public interface IObservable {
    void addObserver(IObserver observer);

    void remove(IObserver observer);

    void notifyUpdate();

}
