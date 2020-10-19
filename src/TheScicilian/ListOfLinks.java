package TheScicilian;

import java.util.List;

public class ListOfLinks<E> {
    private ListNode<E> head;
    private int size;

    public ListOfLinks() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0 || head == null;
    }


    public ListNode<E> getFirst() {
        return head;
    }

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

    public void add(E data) {                                    //sets head if head is null, else adds a node'
        ListNode<E> newNode = new ListNode<>(data);         // We create a new node from the data we are given
        if(this.isEmpty() || this.head == null){
            this.head = newNode;
            size++;
            return;
        }
        getLastNode().setNext(newNode);                     // We go to the last node and change the reference from null to the new node
        size++;                                             // We track our size
    }


    private ListNode<E> getLastNode() {                               //iterates thru the list till the node's next is null (last node)
        ListNode<E> temp = head;
        while(temp.next()!=null){
            temp = temp.next();
        }
        return temp;
    }

    public E getLast(){
        return get(size() - 1);
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
        }else {
            this.getNode(size() - 2).setNext(null);
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


    private class ListNode<E> {                                  //List node: stores a bit of data and a pointer to next
        ListNode<E> next;
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