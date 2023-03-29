package com.RealEstate.Entitites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client_reg")
public class ClientReg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_name")
    private String clientName;

    @Column(name = "client_address")
    private String clientAddress;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String gender;



    @Email(message = "Please provide a valid email address")
    private String Email;

    private String username;

    private String password;


    @OneToOne(mappedBy = "clientReg")
    private Sale sale;


}






