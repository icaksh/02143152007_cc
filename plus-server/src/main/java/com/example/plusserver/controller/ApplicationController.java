package com.example.plusserver.controller;

import com.example.plusserver.dto.InputDto;
import com.example.plusserver.dto.OutputDto;
import com.example.plusserver.service.PlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class ApplicationController {
    @Autowired
    private PlusService plusServic

    @PostMapping("/hitung")
    public ResponseEntity<OutputDto> plusCalculator(@RequestBody InputDto input){
        int hasil = plusService.hitung(input.getA(), input.getB());
        OutputDto dto = new OutputDto();
        dto.setA(input.getA()); in
        dto.setB(input.getB());
        dto.setResult(hasil);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/minus")
    public ResponseEntity<OutputDto> minusCalculator(@RequestBody InputDto input){
        int hasil = plusService.minus(input.getA(), input.getB());
        OutputDto dto = new OutputDto();
        dto.setA(input.getA());
        dto.setB(input.getB());
        dto.setResult(hasil);
        return ResponseEntity.ok(dto);
    }
}
