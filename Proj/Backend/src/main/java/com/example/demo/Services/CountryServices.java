package com.example.demo.Services;

import com.example.demo.Commons.ApiResponse;
import com.example.demo.Commons.CustomConstants;
import com.example.demo.Commons.Status;
import com.example.demo.DTO.CountiresDTO;
import com.example.demo.Model.Countries;
import com.example.demo.Repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServices {
@Autowired
    CountriesRepository repo;

public ApiResponse postToDB(CountiresDTO cdto){
    Countries country = new Countries();
    country.setName(cdto.getName());
    country.setCapital(cdto.getCapital());
    country.setPopulation(cdto.getPopulation());
    country.setAlphaCode(cdto.getAlphaCode());
    country.setRegion(cdto.getRegion());
    country.setSubRegion(cdto.getSubRegion());
    repo.save(country);
    return new ApiResponse(Status.Status_Ok, CustomConstants.COUNTRY_POSTED,country);
}

    public List<Countries> getAll() {
    List<Countries> countries=  repo.findAll();
    return  countries;
    }
}
