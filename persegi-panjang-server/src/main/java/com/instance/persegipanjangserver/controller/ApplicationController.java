package com.instance.persegipanjangserver.controller;


import com.instance.persegipanjangserver.dto.InputDto;
import com.instance.persegipanjangserver.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.instance.persegipanjangserver.services.PersegiPanjangService;

@RestController
public class ApplicationController {
    @Autowired
    private PersegiPanjangService persegiPanjangService;
    @PostMapping("/calc")
    public ResponseEntity<OutputDto> luasPersegiPanjang(@RequestBody InputDto i){
        int hasil = persegiPanjangService.luas(i.getA(), i.getB());
        OutputDto dto = new OutputDto();
        dto.setA(i.getA());
        dto.setB(i.getB());
        dto.setResult(hasil);
        return ResponseEntity.ok(dto);
    }

}
