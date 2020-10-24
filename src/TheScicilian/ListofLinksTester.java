package TheScicilian;

import RuntimeTester.Visualizer;
import RuntimeTester.benchmark;

import java.util.*;

public class ListofLinksTester {
    public static void main(String args[]){
        testQueueMethods();
        for(int i = 0; i < 1500; i++){
            if(!testRemoveFromSizeN(i)) System.out.println("Test failed to remove at size " + i);
        }

        ListOfLinks<String> tested = new ListOfLinks<>();
        for(int i = 0; i < 100; i++){
            long startTime = System.nanoTime();
            fillList(i*15 + 1, tested);
            long endTime = System.nanoTime();
            long startTime2 = System.nanoTime();
            Object first = tested.getFirst();
            long endTime2 = System.nanoTime();
            System.out.println("Slow one, probably O(n) : " + (endTime - startTime) + "             Fast one O(1) : " + (endTime2 - startTime2));


            tested = new ListOfLinks<>();
        }

        Visualizer.launch(ListofLinksTester.class);


    }




    public static void fillList(int numberOfThings, ListOfLinks<String> list){
        Random rand = new Random();
        for(int i = 0; i < numberOfThings; i++){
            if(rand.nextInt(50) == 2){//This makes it spicy
                list.add(null);
            }else{
                list.add("Test " + rand.nextInt(5555) +" " + i);
            }
        }
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

    @benchmark(name="our stack's push")
    public static long pushTest(long input){
        //We make a stack and fill it to the SIZE which is INPUT
        Stack<Integer> s = new Stack<Integer>();
        Random rand = new Random();
        for(int i = 0; i < input; i++){//this for loop uses the Iterator in the Iterable array test
            s.push(rand.nextInt());
        }
        int added = rand.nextInt();
        long startTime = System.nanoTime();
        s.push(added);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    @benchmark(name="our stack's pop")
    public static long popTest(long input){
        //We make a stack and fill it to the SIZE which is INPUT
        Stack<Integer> s = new Stack<Integer>();
        Random rand = new Random();
        for(int i = 0; i < input; i++){//this for loop uses the Iterator in the Iterable array test
            s.push(rand.nextInt());
        }
        long startTime = System.nanoTime();
        s.pop();
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    @benchmark(name = "our get")
    public static long getTest(long input){
        //We make a stack and fill it to the SIZE which is INPUT
        Stack<Integer> s = new Stack<Integer>();
        Random rand = new Random();
        for(int i = 0; i < input; i++){//this for loop uses the Iterator in the Iterable array test
            s.push(rand.nextInt());
        }
        long startTime = System.nanoTime();
        s.get((int)  (2 *input )/ 3);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    @benchmark(name = "our getFaster")
    public static long getFasterTest(long input){
        //We make a stack and fill it to the SIZE which is INPUT
        Stack<Integer> s = new Stack<Integer>();
        Random rand = new Random();
        for(int i = 0; i < input; i++){//this for loop uses the Iterator in the Iterable array test
            s.push(rand.nextInt());
        }
        long startTime = System.nanoTime();
        s.getFaster((int) (2 * input) / 3);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    private static void testStackMethods(){
        Integer[] test = new Integer[]{1,2,3,4,5};
        Stack<Integer> s = new Stack<Integer>();
        //This
        for(Integer i : test){//this for loop uses the Iterator in the Iterable array test
            System.out.println(i);
            s.push(i);
        }

        for(Integer i : s){
            System.out.println(i);
        }

        for(int i = 0; i < test.length; i++){
            System.out.println(s.pop());
        }
    }
    private static void testQueueMethods(){
        Integer[] test = new Integer[]{1,2,3,4,5};
        Queue<Integer> s = new Queue<>();
        //This
        for(Integer i : test){//this for loop uses the Iterator in the Iterable array test
            System.out.println(i);
            s.enqueue(i);
        }

        for(Integer i : s){
            System.out.println(i);
        }

        for(int i = 0; i < test.length; i++){
            System.out.println(s.dequeue());
        }
    }



}
