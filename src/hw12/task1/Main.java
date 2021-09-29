package hw12.task1;

import java.util.*;


public class Main {
    public static void main(String[] args) {

        int[] array = {4,5,-6,4,5,3,4,2,4,5,7};
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : array) {
            arr.add(i);
        }
        print(arr);


        OwnCollection ow = new OwnCollection();
        ow.add(1);
        ow.add(2);
        ow.remove(1);
        System.out.println(ow);
    }

    public static void print(ArrayList<Integer> arr){
        Map<Integer,Integer> map = new HashMap<>();
        Integer counter =1;
        for (Integer i:arr) {
            if(map.containsKey(i)){
                counter=map.get(i);
                map.replace(i,counter,++counter);
                counter=1;
            }else {
                map.put(i,counter);
            }
        }
        System.out.println(map);
    }


}
