package TheScicilian;

public class Stack<E> extends ListOfLinks<E> {
    /**
     * Remove the latest added thing and return it
     * @return the latest added thing
     */
    public E pop(){
        E last = getLast();
        removeLast();//This implementation is SLOW!
        return last;
    }

    /**
     * Return the last added thing
     */
    public E peek(){
        return getLast();
    }

    /**
     * Add a thing to the queue!
     */
    public void push(E data){
        add(data);
    }
}
