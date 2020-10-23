package TheScicilian;

import java.util.Iterator;
import java.util.List;

public class ListOfLinks<E> implements Iterable<E>{
    private ListNode<E> head;
    private ListNode<E> tail;
    private int size = 0;

    public ListOfLinks() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0 || head == null;
    }


    public ListNode<E> getFirst() {
        return head;
    }

    public E getLast(){return tail.getData();};

    public int size() {                                          //Returns the number of elements in the list by iterating thru and counting
        return size;
        //Also works if you have a while loop going through the list and counting how many times you need to go to count the whole list
        //If you have a system where you can combine lists directly by manipulating nodes, you may not always be able to trust int size.
    }

    public E get(int index) throws IndexOutOfBoundsException {   //Gets a node at an index
        if(index > this.size() - 1 || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size());

        int counter = 0;
        E data = null;
        ListNode<E> temp = head;
        while(temp != null){
            if(counter == index){
                return temp.getData();
            }
            temp = temp.next;
            counter++;
        }
        return null;
    }

    private ListNode<E> getNode(int index) throws IndexOutOfBoundsException {   //Gets a node at an index

        if(index > this.size() - 1 || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size());

        int counter = 0;
        E data = null;
        ListNode<E> temp = head;
        while(temp != null){
            if(counter == index){
                return temp;
            }
            temp = temp.next;
            counter++;
        }
        return null;
    }

    public E getFaster(int index) throws IndexOutOfBoundsException{
        if(index > this.size() - 1 || index < 0) throw new IndexOutOfBoundsException("Index " + index + " out of bounds for list of size " + size());

        int counter;
        E data = null;
        ListNode<E> temp;
        if(index > size/2){
            counter = size - 1;
            temp = tail;
            while(temp != null){
                if(counter == index){
                    return temp.getData();
                }
                temp = temp.getPrevious();
                counter--;      //There was a mistake here in the tutorial!
            }
        }else{

            counter = 0;
            temp = head;
            while(temp != null){
                if(counter == index){
                    return temp.getData();
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    public void addFirst(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            head.setPrevious(newNode);
            newNode.setNext(head);
            newNode.setPrevious(null);
            head = newNode;
        }
        size++;
    }

    public void addLast(E data){
        ListNode<E> newNode = new ListNode<>(data);
        if(head == null){
            head = newNode;
            tail = head;
        }else{
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            newNode.setNext(null);
            tail = newNode;
        }
        size++;
    }




    private ListNode<E> getLastNode() {                               //iterates thru the list till the node's next is null (last node)
        ListNode<E> temp = head;
        while(temp.next()!=null){
            temp = temp.next();
        }
        return temp;
    }


    public E pop(){     //Slow and bad, you should use a doubly linked list :)
        E data = getLast();
        removeLast();
        return data;
    }
    //TODO: We fixed this method! Maybe test and fix the rest if you want practice, and notice which ones are O(1), O(N), etc.
    public void removeLast() {
        if(this.size == 0){
            return;
        }
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);

        }
        size--;
    }

    public void removeFirst() {
        if(this.size == 0){
            return;
        }
        if(this.size == 1){
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next();
            this.head.setPrevious(null);
        }
        size--;
    }

    public String toString() {
        //Print all the stuff in this list, comma separated!
        if(this.isEmpty()) return "";               //This caused a crash because we did not consider null when pritning
        StringBuilder sb = new StringBuilder();     //We create a mutable string
        ListNode<E> temp = head;                    //We set our reference to head
        while(temp != null){                        //We loop through
            sb.append(temp.data.toString() + ", ");
            temp = temp.next;

        }
        return sb.toString();                              //return our thing
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListOfLinksIterator();
    }

    class ListOfLinksIterator implements Iterator<E>{
        int index;

        public ListOfLinksIterator(){
            index = 0;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < size();
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws  if the iteration has no more elements
         */
        @Override
        public E next() {
            E data = getFaster(index);
            index++;
            return data;
        }
    }


    protected class ListNode<E> {                                  //List node: stores a bit of data and a pointer to next
        ListNode<E> next;

        public ListNode<E> getPrevious() {
            return previous;
        }


        public void setPrevious(ListNode<E> previous) {
            this.previous = previous;
        }

        ListNode<E> previous;
        E data;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }

        public ListNode<E> next() {
            return next;
        }

        public void setNext(ListNode<E> next) {
            this.next = next;
        }



        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }

    }
}