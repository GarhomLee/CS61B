package synthesizer;

/**Items can only be enqueued at the back of the queue, and can only be dequeued
 * from the front of the queue. Unlike our Deque, the BoundedDeque has a fixed
 * capacity, and nothing is allowed to enqueue if the queue is full.
 */

public interface BoundedQueue<T> {
    int capacity();     // return size of the buffer
    int fillCount();    // return number of items currently in the buffer
    void enqueue(T x);  // add item x to the end
    T dequeue();        // delete and return item from the front
    T peek();           // return (but do not delete) item from the front

    /* return true if the queue is empty (fillCount equals zero). */
    default boolean isEmpty() {
        return fillCount() == 0;
    }
    /* return false if the queue is full (fillCount is same as capacity). */

    default boolean isFull() {
        return  fillCount() == capacity();
    }
}
