package com.RealEstate.Controller;

import com.RealEstate.Payload.SaleDto;
import com.RealEstate.Service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public ResponseEntity<SaleDto> saveSale(@RequestBody SaleDto saleDto) {
        SaleDto saleDto1 = saleService.saveSale(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saleDto1);
    }
}
