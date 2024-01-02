package com.instance.layanglayangserver.controller;


import com.instance.layanglayangserver.dto.InputDto;
import com.instance.layanglayangserver.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.instance.layanglayangserver.services.LayangLayangService;

@RestController
public class ApplicationController {
    @Autowired
    private LayangLayangService layangLayangService;
    @PostMapping("/calc")
    public ResponseEntity<OutputDto> luasLayangLayang(@RequestBody InputDto i){
        double hasil = layangLayangService.luas(i.getA(), i.getB());
        OutputDto dto = new OutputDto();
        dto.setA(i.getA());
        dto.setB(i.getB());
        dto.setResult(hasil);
        return ResponseEntity.ok(dto);
    }

}
