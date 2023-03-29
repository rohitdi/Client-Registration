package com.RealEstate.Controller;

import com.RealEstate.Entitites.ClientReg;
import com.RealEstate.Payload.ClientRegDto;
import com.RealEstate.Service.ClientRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clients")
public class ClientRegController {

    @Autowired
    private ClientRegService clientRegService;

    //http://localhost:8080/api/clients/create
    @PostMapping("/create")
    public ResponseEntity<String> createClientUser(@RequestBody ClientRegDto clientRegDto) {
        clientRegService.createClientUser(clientRegDto);
        return new ResponseEntity<>("User updated Successfully", HttpStatus.CREATED);

    }
}
