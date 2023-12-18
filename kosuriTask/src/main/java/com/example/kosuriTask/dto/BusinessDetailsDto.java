package com.example.kosuriTask.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class BusinessDetailsDto  {
    private long userId;
    private String name;
    private String contactEmail;
    private long phoneNumber ;
    private String businessName;
    private String nbfcApproved;
    private String nbfcRegistrationNumber;
    private Date registartionDate;
    private String gstRegistration;
    private Date updatedDetails;

}
