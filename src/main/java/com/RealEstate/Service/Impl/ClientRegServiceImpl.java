package com.RealEstate.Service.Impl;

import com.RealEstate.Entitites.ClientReg;
import com.RealEstate.Payload.ClientRegDto;
import com.RealEstate.Repository.ClientRegRepository;
import com.RealEstate.Service.ClientRegService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientRegServiceImpl implements ClientRegService {


    private PasswordEncoder passwordEncoder;

    private ClientRegRepository clientRegRepository;

    public ClientRegServiceImpl(PasswordEncoder passwordEncoder, ClientRegRepository clientRegRepository) {
        this.passwordEncoder = passwordEncoder;
        this.clientRegRepository = clientRegRepository;
    }

    @Override
    public void createClientUser(ClientRegDto clientRegDto) {
        ClientReg clientReg = MapToEntity(clientRegDto);
        clientRegRepository.save(clientReg);


    }

    ClientReg MapToEntity(ClientRegDto clientRegDto){
        ClientReg clientReg = new ClientReg();
        clientReg.setClientAddress(clientRegDto.getClientAddress());
        clientReg.setClientName(clientRegDto.getClientName());
        clientReg.setGender(clientRegDto.getGender());
        clientReg.setEmail(clientRegDto.getEmail());
        clientReg.setUsername(clientRegDto.getUsername());
        clientReg.setPhoneNumber(clientRegDto.getPhoneNumber());
        clientReg.setPassword(passwordEncoder.encode(clientRegDto.getPassword()));
        return clientReg;

    }
}
