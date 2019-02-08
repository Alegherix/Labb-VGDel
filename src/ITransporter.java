import java.util.Deque;

public interface ITransporter {

    boolean canBeLoaded();

    // Möjligt att det räcker med att bara kunna invertera canBeLoaded
    boolean unLoadable();

    void unLoad();

    void load();

    boolean isMoving();

    Position getTransporterPosition();

    Deque<ITransportable> getTransportables();

    Direction getDirection();

}
