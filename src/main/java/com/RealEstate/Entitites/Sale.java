package com.RealEstate.Entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "property_id")
    private Long propertyId;

    @Column(name = "sale_date")
    private Date saleDate;

    @OneToOne
    @JoinColumn(name = "client_id")
    private ClientReg clientReg;

}

