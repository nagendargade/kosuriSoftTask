package com.example.kosuriTask.controller;

import com.example.kosuriTask.dto.AssetCategoryDto;
import com.example.kosuriTask.service.AssetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class AssetCategoryController {
    @Autowired
    private AssetCategoryService assetCategoryService;


    @PostMapping("/addAsetCtgry/{contactEmail}")
    public ResponseEntity<AssetCategoryDto> addTenureDetails(@RequestBody AssetCategoryDto assetCategoryDto,
                                                             @PathVariable String contactEmail){
        return  new ResponseEntity<>(assetCategoryService.addAsetCtgry(assetCategoryDto, contactEmail), HttpStatus.CREATED);

    }

    @GetMapping("/getAsetCtgryDetails/{contactEmail}")
    public ResponseEntity<List<AssetCategoryDto>>   getFinceTenureBymail(@PathVariable String contactEmail){

        return  new ResponseEntity<>(assetCategoryService.getAsetCtgryByContactEmail(contactEmail),HttpStatus.OK);
    }

    @PutMapping("/updateAsetCtgry/{contactEmail}/{id}")
    public ResponseEntity<AssetCategoryDto>  updateFinTenure(@RequestBody AssetCategoryDto assetCategoryDto,
                                                               @PathVariable  String contactEmail,
                                                               @PathVariable long id){
        return new ResponseEntity<>(assetCategoryService.updateAsetCtgryByContEmail(assetCategoryDto, contactEmail,id),HttpStatus.OK);
    }





}
