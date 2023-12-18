package com.example.kosuriTask.controller;


import com.example.kosuriTask.dto.BusinessDetailsDto;
import com.example.kosuriTask.service.BusinessDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.kosuriTask.exceptionHandling.Exception;


@RestController
@RequestMapping("")
public class BusinessDetailsController {

    @Autowired
    BusinessDetailsService businessDetailsService;

    @PostMapping("/AddBusiness")
    public ResponseEntity<?> saveBusinessData(@RequestBody BusinessDetailsDto businessDetailsDto) {
        try {
            BusinessDetailsDto savedDetails = businessDetailsService.businessData(businessDetailsDto);
            return new ResponseEntity<>(savedDetails, HttpStatus.CREATED);
        } catch (Exception e) {
            // Handle the case where a duplicate email is encountered
            String errorMessage = "Email already exists: " + businessDetailsDto.getContactEmail();
            return new ResponseEntity<>(errorMessage, HttpStatus.CONFLICT);
        }

    }

    @GetMapping("/getdetails/{contactEmail}")
    public  ResponseEntity<?> getById(@PathVariable String contactEmail){
       try{
           return new ResponseEntity<>(businessDetailsService.getDetails(contactEmail),HttpStatus.OK);
       }catch (Exception e){
           String errorMessage = "Details not found for contact email: " + contactEmail;
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
       }

    }

    @PutMapping("/update-details/{contactEmail}")
    public ResponseEntity<?> updateBusinessDetails(
            @RequestBody BusinessDetailsDto businessDetailsDto,
            @PathVariable String contactEmail) {
        try {
            BusinessDetailsDto updatedDetails = businessDetailsService.updateBusnDetails(businessDetailsDto, contactEmail);
            return new ResponseEntity<>(updatedDetails, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the case where details are not found
            String errorMessage = "Details not found for contact email: " + contactEmail;
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            // Handle the case where businessDetailsDto is null
            return new ResponseEntity<>("Invalid request: BusinessDetailsDto cannot be null", HttpStatus.BAD_REQUEST);
        }
    }


}
