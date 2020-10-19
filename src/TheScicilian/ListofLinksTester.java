package TheScicilian;

import java.util.Random;
import java.util.Scanner;

public class ListofLinksTester {
    public static void main(String args[]){
       testStackMethods();
       testQueueMethods();

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

    private static void testStackMethods(){
        Stack<Integer> nums = new Stack<>();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        nums.push(one);
        nums.push(two);
        nums.push(three);
        for(Integer i : nums){
            System.out.println(i);
        }
        for(int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }
        while(!nums.isEmpty()) {
            System.out.println(nums.pop());
        }
    }

    private static void testQueueMethods(){
        Queue<Integer> nums = new Queue<>();
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        nums.enqueue(one);
        nums.enqueue(two);
        nums.enqueue(three);

        while(!nums.isEmpty()) {
            System.out.println(nums.dequeue());
        }
    }

}
