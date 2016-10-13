package com.example.user.myapplication;

public class GetMin extends MyValue{

    int Min = arr[0];
    int test = arr[0];

    public int getResult(){
        for(int i = 0 ; i <arr.length ; i++){
            if(Min > arr[i])
                Min = arr[i];
        }
        return Min;
    }

}
