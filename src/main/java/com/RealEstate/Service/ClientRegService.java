package com.RealEstate.Service;

import com.RealEstate.Entitites.ClientReg;
import com.RealEstate.Payload.ClientRegDto;

public interface ClientRegService {

    public void createClientUser(ClientRegDto clientRegDto);
}
