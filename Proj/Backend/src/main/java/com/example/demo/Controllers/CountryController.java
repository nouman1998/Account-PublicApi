package com.example.demo.Controllers;

import com.example.demo.Commons.ApiResponse;
import com.example.demo.Commons.CustomConstants;
import com.example.demo.Commons.Status;
import com.example.demo.DTO.CountiresDTO;
import com.example.demo.Model.Countries;
import com.example.demo.Repository.CountriesRepository;
import com.example.demo.Services.CountryServices;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/country")
public class CountryController {

@Autowired
    CountryServices cs;

@Autowired
    CountriesRepository repo;



    @PostMapping("/")
    public ApiResponse addToDB(@RequestBody CountiresDTO cdto){
       return cs.postToDB(cdto);
    }


    @GetMapping("/")
    public List<Countries> getAll(){
        return cs.getAll();
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteById(@PathVariable("id") Long id){
        repo.deleteById(id);
        return  new ApiResponse(Status.Status_Ok, CustomConstants.COUNTRY_DELETED,null);
    }

    @DeleteMapping("/")
    public ApiResponse deleteAll(){
        repo.deleteAll();

        return  new ApiResponse(Status.Status_Ok, CustomConstants.COUNTRY_DELETED,null);
    }

}
