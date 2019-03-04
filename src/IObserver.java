import java.util.List;

public interface IObserver {
    void update();

    void updateList(List<Vehicle> vehicles);
}
