package com.instance.layanglayangserver.services;


import org.springframework.stereotype.Service;

@Service
public class LayangLayangService {
    public double luas(int a, int b){
        return (double)(a * b)/2;
    }
}
