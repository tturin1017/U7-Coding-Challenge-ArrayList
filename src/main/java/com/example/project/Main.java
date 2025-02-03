package com.example.project;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    
    
    /** Inserts toInsert after each String in stringList
    *  that contains the letter "i"
    *
    *  DOES mutate (modify) elements of stringList.
    *  PRECONDITION: stringList.size() > 0, toInsert.length() > 0
    *
    *  @param stringList  original arraylist of Strings
    *  @param str String to insert
    */
    public static ArrayList<String> insertAfterI(ArrayList<String> stringList, String str){
        for(int i =0 ; i < stringList.size(); i++){
            if(stringList.get(i).contains("i")){
                stringList.add(i+1,str);
                i++;
            }
        }
        
        return stringList;
    }

    /** Removes all Strings from stringList that have a length of 3
   *
   *  DOES mutate (modify) elements of stringList.
   *  PRECONDITION: stringList.size() > 0
   *
   *  @param stringList  original arraylist of Strings
   */
    public static ArrayList<String> removeThree(ArrayList<String> stringList){
        for(int i =0; i<stringList.size(); i++){
            if(stringList.get(i).length()==3){
                stringList.remove(i);
                i--;
            }
        }

        return stringList;
    }

    /** Returns an ArrayList with all elements of arr reversed
   *
   *  Does NOT mutate (modify) elements in intList.
   *  PRECONDITION: intList.size() > 0
   *
   *  @param intList  original array of integers
   */
    public static ArrayList<Integer> reverseArray(int[] intList){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=intList.length-1;i>=0;i--){
            list.add(intList[i]);
        }
        return list;
    }


 
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list,"this", "is", "not", "a", "trivial", "task", "right?");
        ArrayList<String> expected = new ArrayList<>();
        Collections.addAll(expected,"this", "bob","is","bob","not", "a", "trivial", "bob","task", "right?", "bob" );

        System.out.println(insertAfterI(list, "bob"));
    }


    // Given an array of ints, 
    // return true if the array is length 1 or more, 
    // and the first element and the last element are equal.
    // sameFirstLast([1, 2, 3]) → false
    // sameFirstLast([1, 2, 3, 1]) → true
    // sameFirstLast([1, 2, 1]) → true
    //sameFirstLast([]) -> false
    public static boolean sameFirstLast(ArrayList<Integer> list){
        if(list.size()>0){
            if(list.get(0) == list.get(list.size()-1)){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    // Given an array of ints, swap the first and last elements in the array. 
    // Return the modified array. The array length will be at least 1.
    // swapEnds([1, 2, 3, 4]) → [4, 2, 3, 1]
    // swapEnds([1, 2, 3]) → [3, 2, 1]
    // swapEnds([8, 6, 7, 9, 5]) → [5, 6, 7, 9, 8]
    // swapEnds([]->[])
    public static ArrayList<Integer> swapEnds(ArrayList<Integer> list){
        if(list.size()>0){
            Integer temp = list.set(0,list.get(list.size()-1));
            list.set(list.size()-1,temp);
        }
        
        return list;
    }

    // Return an array that contains the exact same numbers as the given array, 
    // but rearranged so that all the zeros are grouped at the start of the array. 
    // The order of the non-zero numbers does not matter. So {1, 0, 0, 1} becomes {0 ,0, 1, 1}. 
    // You may modify and return the given array or make a new array.
    // zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
    // zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
    // zeroFront([1, 0]) → [0, 1]
    public static ArrayList<Integer> zeroFront(ArrayList<Integer> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i)==0){
                list.remove(i);
                list.add(0,0);
            }
        }
        return list;
    }

    // We'll say that an element in an array is "alone" if there are values before and after it, 
    // and those values are different from it. If the value is at the end compare to the left and if its at the beginning compare to the right
    //Return a version of the given array where every instance 
    // of the given value which is alone is replaced by whichever value to its left or right is larger.
    // notAlone([1, 2, 3], 2) → [1, 3, 3]
    // notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 5]
    // notAlone([3, 4], 3) → [3, 3]
    public static ArrayList<Integer> notAlone(ArrayList<Integer> list, int val){
        for(int i=0;i<list.size();i++){
            if(val==list.get(i)){
                //check if first item inthe list 
                if(i==0){
                    if(list.get(i)!=list.get(i+1)){
                        list.set(i,list.get(i+1));
                    }
                }else if(i==list.size()-1){ //check if last item in the list
                    if(list.get(i)!=list.get(i-1)){
                        list.set(i,list.get(i-1));
                    }
                }else{
                    if(list.get(i)!=list.get(i-1)&&list.get(i)!=list.get(i+1)){ //if elements doesnt equal to the left or right
                        if(list.get(i-1)>list.get(i+1)){//if left element is larger than right 
                            list.set(i,list.get(i-1));//set element to left
                        }else{
                            list.set(i,list.get(i+1));//set element to right if right is larger
                        }
                    }
                }
            }
        }
        return list;
    }

    // Return an array that is "left shifted" by one -- so {6, 2, 5, 3} returns {2, 5, 3, 6}. 
    // You may modify and return the given array;
    // shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
    // shiftLeft([1, 2]) → [2, 1]
    // shiftLeft([1]) → [1]

    public static ArrayList<Integer> shiftLeft(ArrayList<Integer> list){
        if(list.size()!=1){
            int temp = list.get(list.size()-1); //save original value of last item 
            list.set(list.size()-1,list.get(0));//set last item in list with the first item in list
            for(int i=0; i<list.size()-2;i++){
                list.set(i,list.get(i+1));
            }
            list.set(list.size()-2,temp); //second to last item in the list with temp
        }
        return list;
    }
    
    // Return an array that contains exactly the same numbers as the given array, 
    // but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
    // but every other number may move. The array contains the same number of 3's and 4's, 
    // every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.
    // fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
    // fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
    // fix34([3, 2, 2, 4]) → [3, 4, 2, 2]

    public static ArrayList<Integer> fix34(ArrayList<Integer> list){
        int last_4 = -1;
        for(int i =0 ; i < list.size(); i ++){
            if(list.get(i)==3){
                for(int j=0;j<list.size();j++){
                    if(list.get(j)==4 && j>last_4){
                        //swap
                        int temp = list.get(j);
                        list.set(j,list.get(i+1));
                        list.set(i+1,temp);
                        last_4 = j;
                    }
                }
            }
        }
        return list;
    }

    


    // public static void main(String[] args) {
    //     ArrayList<Integer> x = new ArrayList<Integer>();
    //     Collections.addAll(x,1, 3, 1, 4, 4, 3, 1);
    //     System.out.println(fix34(x));
    // }

}