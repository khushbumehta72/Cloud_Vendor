package com.dumbo.demo.controller;

import com.dumbo.demo.model.CloudVendor;
import com.dumbo.demo.response.ResponseHandler;
import com.dumbo.demo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor/")
public class CloudVendorController {

    private final CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){

       return ResponseHandler.responseBuilder("Requested vendor details are given here",
               HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));


    }
    @GetMapping("")
    public List<CloudVendor> getAllCloudVendorDetails(String vendorId){

        return cloudVendorService.getAllCloudVendors();

    }
    @PostMapping("")
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
      cloudVendorService.createCloudVendor(cloudVendor);
       return "Cloud Vendor Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        cloudVendorService.updateCloudVendor(cloudVendor);
        return "Cloud Vendor updated Successfully";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId ){
       cloudVendorService.deleteCloudVendor(vendorId);
        return "Cloud Vendor deleted Successfully";
    }


}
