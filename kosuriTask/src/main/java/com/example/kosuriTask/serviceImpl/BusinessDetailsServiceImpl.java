package com.example.kosuriTask.serviceImpl;


import com.example.kosuriTask.dto.BusinessDetailsDto;
import com.example.kosuriTask.entity.BusinessDetails;
import com.example.kosuriTask.exceptionHandling.Exception;
import com.example.kosuriTask.repository.BusinessDetailsRepo;
import com.example.kosuriTask.service.BusinessDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessDetailsServiceImpl implements BusinessDetailsService {
    @Autowired
    BusinessDetailsRepo businessDetailsRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BusinessDetailsDto businessData(BusinessDetailsDto businessDetailsDto) {
        // Map DTO to entity
        BusinessDetails businessDetails = modelMapper.map(businessDetailsDto, BusinessDetails.class);
        // Check if the email already exists
        if (businessDetailsRepo.existsByContactEmail(businessDetails.getContactEmail())) {
            throw new Exception("Email already exists: " + businessDetails.getContactEmail());
        }
        // Save the new BusinessDetails
        BusinessDetails savedBusinessDetails = businessDetailsRepo.save(businessDetails);
        return modelMapper.map(savedBusinessDetails, BusinessDetailsDto.class);
    }


    @Override
    public BusinessDetailsDto getDetails(String contactEmail) {
        BusinessDetails details = businessDetailsRepo.findByContactEmail(contactEmail).orElse(null);
        if (details != null) {
            return modelMapper.map(details, BusinessDetailsDto.class);
        } else {
            // Handle the case where details are not found
            throw new Exception("Details not found for contact email: " + contactEmail);
            // Alternatively, you can return an empty response or handle it based on your use case
        }
    }

    @Override
    public BusinessDetailsDto updateBusnDetails(BusinessDetailsDto details, String contactEmail) {

        BusinessDetails existingDetails = businessDetailsRepo.findByContactEmail(contactEmail).orElse(null);
        if (existingDetails != null) {
            // Update existing details with the new values
            existingDetails.setName(details.getName());
            existingDetails.setBusinessName(details.getBusinessName());
            existingDetails.setNbfcApproved(details.getNbfcApproved());
            existingDetails.setPhoneNumber(details.getPhoneNumber());
            existingDetails.setGstRegistration(details.getGstRegistration());
            existingDetails.setNbfcRegistrationNumber(details.getNbfcRegistrationNumber());
            // Save the updated details
            BusinessDetails updatedDetails = businessDetailsRepo.save(existingDetails);
            return modelMapper.map(updatedDetails, BusinessDetailsDto.class);
        } else {
            // Handle the case where the contact email does not exist
            throw new Exception("Details not found for contact email: " + contactEmail);
            // Alternatively, you can return an error response or handle it based on your use case
        }
    }


}
