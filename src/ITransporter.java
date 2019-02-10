import java.util.Deque;

public interface ITransporter<T> {

    void load(T t);

    /**
     * Kommer vara unik för både Semi och för Ferry, PollFirsrt, PollLAst
     * @return
     */
    T unload();

    boolean isFull();

    Deque<T> getTransported();

    Position getPosition();


    boolean withinValidLoadingrange(T t);


}
