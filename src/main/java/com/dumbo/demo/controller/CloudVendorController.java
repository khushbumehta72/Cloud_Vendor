package com.dumbo.demo.controller;

import com.dumbo.demo.model.CloudVendor;
import com.dumbo.demo.service.CloudVendorService;
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
    public CloudVendor getCloudVendorDetails(@PathVariable("vendorId") String vendorId){

       return cloudVendorService.getCloudVendor(vendorId);

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
