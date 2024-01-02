package com.instance.persegipanjangserver.services;


import org.springframework.stereotype.Service;

@Service
public class PersegiPanjangService {
    public int luas(int a, int b){
        return (a * b);
    }
}
