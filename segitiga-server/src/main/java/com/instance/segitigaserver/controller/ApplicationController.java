package com.instance.segitigaserver.controller;


import com.instance.segitigaserver.dto.InputDto;
import com.instance.segitigaserver.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.instance.segitigaserver.services.SegitigaService;

@RestController
public class ApplicationController {
    @Autowired
    private SegitigaService segitigaService;
    @PostMapping("/calc")
    public ResponseEntity<OutputDto> luasSegitiga(@RequestBody InputDto i){
        double hasil = segitigaService.luas(i.getA(), i.getB());
        OutputDto dto = new OutputDto();
        dto.setA(i.getA());
        dto.setB(i.getB());
        dto.setResult(hasil);
        return ResponseEntity.ok(dto);
    }

}
