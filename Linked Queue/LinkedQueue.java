/******************************************************************************
 *
 * Implements the generic queue interface using a linked list.
 * Author: HENRY WANDOVER
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The {@code LinkedQueue} class represents a first-in-first-out
 * (FIFO) queue of object references. It supports the usual
 * <em>enqueue</em> and <em>dequeue</em> operations, along with
 * methods for peeking at the top item, etc.
 *
 * This implementation uses a singly-linked list with a nested class
 * for linked-list nodes. The <em>enqueue</em>, <em>dequeue</em>,
 * <em>peek</em>, <em>size</em>, and <em>isEmpty</em> operations all
 * take constant time in the worst case.
 * @author S. Anderson based
 * @author Henry W.
 */

public class LinkedQueue<T> implements Queue<T>,Iterable<T> {
    private int N;        // number of elements on queue
    private Node head;    // beginning of queue
    private Node tail;    // end of queue

    // helper class for nodes in a linked structure
    private class Node 
    {
        private T item;   // the item in the node
        private Node next;   // reference to next item

	public Node(T theitem, Node thenext) 
    {
	    this.item = theitem;
	    this.next = thenext;
	}
	    
    } // end of Node class

    /**
     * Initializes an empty queue.
     */
    public LinkedQueue() 
    {
        head = null;
        tail = null;
        N = 0;
    }

    /**
     * Returns true if this queue is empty.
     *
     * @return {@code true} if this queue is empty; {@code false} otherwise
     */
    public boolean isEmpty() { return head == null; }

    /**
     * Returns the number of items in this queue.
     *
     * @return the number of items in this queue
     */
    public int size() { return N; }

    /**
     * Returns the item least recently added to this queue.
     *
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T peek() 
    {
        if (N == 0) throw new NoSuchElementException("Queue is empty");

        return head.item;
    }

    /**
     * Add the item to the queue.
     * 
     * @param item the item to be added to the queue
     */
    public void enqueue(T item) 
    {
        if (item != null) 
        {
            Node oldTail = tail;
            tail = new Node(item, null);
            if (isEmpty()) head = tail;
            else oldTail.next = tail;
            N++;
        } else {
            N = N;
        }
    }

    /**
     * Removes and returns the head item.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public T dequeue() 
    {
        if (head == null) throw new NoSuchElementException( "Queue is empty");

        T item = head.item;
        head = head.next;
        if (isEmpty()) tail = null;
        N--;
        return item;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        for (T item : this)
        {
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }


    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     *
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public Iterator<T> iterator() 
    {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<T> 
    {
        private Node current;  // node containing current item

        public boolean hasNext() { return current.next != null; }

        // Not implemented
	    public void remove() 
        {
	        // leave this next line.
            throw new UnsupportedOperationException();
        }

        public T next() 
        {
            if (!hasNext()) throw new NoSuchElementException();
	        T item = current.item;
            current = current.next;
            return item;
        }
    } // end of ListIterator

} // end of LinkedQueue

