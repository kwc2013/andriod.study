package com.example.user.quickcoding02;

public class MyValue {

    public int binarySearch(int min, int max){
        int[] num = new int[max-min+1];

        int tmp = min;

        for(int i = 0 ; i<num.length; i++){
            num[i] = tmp;
            ++tmp;
        }
        return  num[num.length/2];
    }




}
