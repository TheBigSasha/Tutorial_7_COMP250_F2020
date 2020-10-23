package TheScicilian;

public class CoolStack<E> extends ListOfLinks<E>{
    public E pop(){
        E returned = getLast();
        removeLast();
        return returned;
    }

    public void push(E data){addLast(data);}

    //Because of the double list, the iterator reverses things!



}
