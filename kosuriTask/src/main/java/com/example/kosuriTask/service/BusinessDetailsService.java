package com.example.kosuriTask.service;


import com.example.kosuriTask.dto.BusinessDetailsDto;

public interface BusinessDetailsService {
    BusinessDetailsDto businessData (BusinessDetailsDto businessDetailsDto);
    BusinessDetailsDto getDetails(String contactEmail);
    BusinessDetailsDto updateBusnDetails(BusinessDetailsDto details, String contactEmail);

}
