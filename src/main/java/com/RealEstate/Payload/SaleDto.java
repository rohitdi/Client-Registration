package com.RealEstate.Payload;

import com.RealEstate.Entitites.ClientReg;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class SaleDto {

    private Long clientId;
    private Long agentId;
    private Long propertyId;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date saleDate;

    private ClientReg clientReg;
}
