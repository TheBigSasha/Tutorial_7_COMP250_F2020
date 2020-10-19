package TheScicilian;

import java.util.Random;
import java.util.Scanner;

public class ListofLinksTester {
    public static void main(String args[]){
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

    }

}
