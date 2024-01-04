/******************************************************************************
 *  A generic FIFO queue interface.  This includes an interator for
 * the type TYPE, so one can use foreach loops with the queue.
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface Queue<TYPE> extends Iterable<TYPE> {

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size();

    /**
     * Returns the item at the head of the queue (least recently added).
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public TYPE peek();
    

    /**
     * Add the item to the queue at the tail position.
     */
    public void enqueue(TYPE item);

    /**
     * Removes and returns the item at the head of 
     * this queue.
     *
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public TYPE dequeue();
}
