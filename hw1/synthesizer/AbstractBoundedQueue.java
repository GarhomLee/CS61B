package synthesizer;

public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T>{
    protected int fillCount;
    protected int capacity;
    @Override
    /* get the capacity of the array. */
    public int capacity() {
        return capacity;
    }
    @Override
    /* get the current fill count. */
    public int fillCount() {
        return fillCount;
    }
}
