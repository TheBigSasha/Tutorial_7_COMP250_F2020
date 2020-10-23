package TheScicilian;

import java.util.Random;
import java.util.Scanner;

public class ListofLinksTester {

    //We expect:
    //O(1) - getFaster(end), getFaster(start), get(start)
    //O(N) - getFaster(mid), get(mid), get(end)
    //O(1) - enqueue(), dequeue(), push(), pop()

    public static void main(String args[]){
        testGetFaster();
        testQueueMethods();
        testStackMethods();
        for(int i = 0; i < 1500; i++){
            if(!testRemoveFromSizeN(i)) System.out.println("Test failed to remove at size " + i);
        }

        ListOfLinks<String> tested = new ListOfLinks<>();
        for(int i = 0; i < 10000; i+=100){
            long startTime = System.nanoTime();
            fillList(i*15 + 1, tested);
            long endTime = System.nanoTime();
            long startTime2 = System.nanoTime();
            Object first = tested.getFirst();
            long endTime2 = System.nanoTime();
            System.out.println("Mid Slow : " + getFromMiddle(i) + " Mid Fast : " + getFromMiddleFaster(i) + " End Fast : " + getFromEndFaster(i) +  " End Slow : " + getFromEnd(i) + " Start Fast : " + getFromStartFaster(i) + " Start Slow : " + getFromStart(i) );


            tested = new ListOfLinks<>();
        }


    }

    public static void fillList(int numberOfThings, ListOfLinks<String> list, boolean isNull){
        Random rand = new Random();
        for(int i = 0; i < numberOfThings; i++){
            if(rand.nextInt(50) == 2 && isNull){//This makes it spicy
                list.addFirst(null);
            }else{
                list.addFirst("Test " + rand.nextInt(5555) +" " + i);
            }
        }
    }


    public static void fillList(int numberOfThings, ListOfLinks<String> list){
        Random rand = new Random();
        for(int i = 0; i < numberOfThings; i++){

                list.addFirst("Test " + rand.nextInt(5555) +" " + i);
        }
    }

    private static long getFromMiddle(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.get(size/2);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getFromMiddleFaster(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.getFaster(size/2);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getFromStartFaster(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.getFaster(0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getFromStart(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.get(0);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getFromEnd(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.get(size - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private static long getFromEndFaster(int size){
        if(size < 1) size = 2;
        ListOfLinks<String> myList = new ListOfLinks<>();
        fillList((int) size, myList);
        long startTime = System.nanoTime();
        myList.getFaster(size - 1);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }




    private static boolean testRemoveFromEmpty(){
        try {
            ListOfLinks<String> list = new ListOfLinks<>();
            list.removeLast();
            if(list.isEmpty() && list.size() == 0){     //We want to test for collateral damage
                //Does the list size change out of sync with what's in the list.
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
    private static boolean testRemoveFromSize1(){
        try {
            ListOfLinks<String> list = new ListOfLinks<>();
            fillList(1, list);
            list.removeLast();
            if(list.isEmpty() && list.size() == 0){     //We want to test for collateral damage
                //Does the list size change out of sync with what's in the list.
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    private static boolean testRemoveFromSizeN(int intensity){
        if(intensity <= 0){
            return testRemoveFromEmpty();
        }else if(intensity == 1){
            return testRemoveFromSize1();
        }
        try {
            ListOfLinks<String> list = new ListOfLinks<>();
            fillList(intensity, list);
            list.removeLast();
            if(list.size() == intensity - 1){     //We want to test for collateral damage
                //Does the list size change out of sync with what's in the list.
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private static long testIterationSpeed(int intensity){
        return 0L;
    }

    private static void testIterationFunction(){

    }

    private static void testStackMethods(){
        CoolStack<Integer> nums = new CoolStack<>();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        nums.push(one);
        nums.push(two);
        nums.push(three);
        for(Integer i : nums){
            System.out.println("Stack test iterator <expected 1 2 3>    " + i);
        }
        for(int i = 0; i < nums.size(); i++){
            System.out.println("Stack test for loop <expected 1 2 3>    " +nums.get(i));
        }
        while(!nums.isEmpty()) {
            System.out.println("Stack test pop <expected 3 2 1>         " +nums.pop());
        }
    }

    private static void testQueueMethods(){
        CoolQueue<Integer> nums = new CoolQueue<>();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        nums.enqueue(one);
        nums.enqueue(two);
        nums.enqueue(three);

        while(!nums.isEmpty()) {
            System.out.println("Queue test <expected 1 2 3>             " +           nums.dequeue());
        }
    }

    private static void testGetFaster(){
        ListOfLinks<String> list = new ListOfLinks<>();
        fillList(100, list);
        for(int i = 0; i < list.size(); i++){
            if(!list.get(i).equals(list.getFaster(i))) System.out.println("ERROR AT INDEX " + i);
        }


    }

}
