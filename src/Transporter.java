import java.util.Deque;


/**
 * En klass som kan transportera Transporterbara saker, och använder sig av Transporter metoder.
 * @param <T>
 */
public abstract class Transporter <T extends ITransportable> implements ITransporter{

    private Position position;
    private Direction direction;
    private T t;
    private Deque<ITransportable> transportables;
    private double speed;


    public abstract boolean canBeLoaded();

    public abstract boolean unLoadable();

    /**
     * Olika beroende på vad för typ. t.ex en truck unloadar bakom sig, en färja framför sig.
     */
    public abstract void unLoad();


    public abstract void load();

    public Deque<ITransportable> getTransportables(){
        return transportables;
    }

    @Override
    public boolean isMoving() {
        return speed > 0;
    }

    @Override
    public Position getTransporterPosition() {
        return position;
    }
}
