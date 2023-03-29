package com.RealEstate.Service.Impl;

import com.RealEstate.Entitites.ClientReg;
import com.RealEstate.Entitites.Sale;
import com.RealEstate.Payload.SaleDto;
import com.RealEstate.Repository.ClientRegRepository;
import com.RealEstate.Repository.SaleRepository;
import com.RealEstate.Service.SaleService;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class SaleServiceImpl implements SaleService {


    private SaleRepository saleRepository;
    private ClientRegRepository clientRegRepository;


    public SaleServiceImpl(SaleRepository saleRepository, ClientRegRepository clientRegRepository) {
        this.saleRepository = saleRepository;
        this.clientRegRepository = clientRegRepository;
    }


    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        ClientReg clientReg = clientRegRepository.findById(saleDto.getClientId())
                .orElseThrow(() -> new EntityNotFoundException("Client not found with id" + saleDto.getClientId()));

        Sale sale = new Sale();
        sale.setClientId(saleDto.getClientId());
        sale.setAgentId(saleDto.getAgentId());
        sale.setPropertyId(saleDto.getPropertyId());
        sale.setSaleDate(saleDto.getSaleDate() != null ? saleDto.getSaleDate() : new Date());

        //sale.setClientReg(clientReg); // Set the clientReg on the sale

        Sale savedSale = saleRepository.save(sale);

        SaleDto dto = new SaleDto();
        dto.setClientId(savedSale.getClientId());
        dto.setClientReg(clientReg); // Set the clientReg on the SaleDto
        dto.setAgentId(savedSale.getAgentId());
        dto.setPropertyId(savedSale.getPropertyId());
        dto.setSaleDate(savedSale.getSaleDate() != null ? savedSale.getSaleDate() : new Date());

        return dto;

    }



}
