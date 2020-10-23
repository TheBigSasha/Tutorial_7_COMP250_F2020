package TheScicilian;

public class CoolQueue<E> extends ListOfLinks<E> {
    public void enqueue(E data){
        addFirst(data);
    }

    public E dequeue(){
        E data = getLast();
        removeLast();
        return data;
    }
}
