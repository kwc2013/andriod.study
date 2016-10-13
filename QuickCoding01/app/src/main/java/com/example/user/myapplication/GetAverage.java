package com.example.user.myapplication;

public class GetAverage extends MyValue{

    int average;

    public int getResult(){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        return average = sum/arr.length;
    }
}
