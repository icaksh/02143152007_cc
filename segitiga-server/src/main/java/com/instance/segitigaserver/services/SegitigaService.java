package com.instance.segitigaserver.services;


import org.springframework.stereotype.Service;

@Service
public class SegitigaService {
    public double luas(int a, int b){
        return (double) (a * b)/2;
    }
}
