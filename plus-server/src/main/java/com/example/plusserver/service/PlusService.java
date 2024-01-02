package com.example.plusserver.service;

import org.springframework.stereotype.Service;

@Service
public class PlusService {
    public int hitung(int a, int b){
        return a +b;
    }

    public int minus(int a, int b){
        return a - b;
    }
}
