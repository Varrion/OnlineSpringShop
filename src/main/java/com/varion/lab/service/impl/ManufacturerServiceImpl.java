package com.varion.lab.service.impl;

import com.varion.lab.model.Manufacturer;
import com.varion.lab.repository.ManufacturerRepository;
import com.varion.lab.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public Manufacturer saveManufacturer (String name){

        Manufacturer manufacturer=new Manufacturer();
        manufacturer.setName(name);

        return this.manufacturerRepository.save(manufacturer);
    }

  /*  @Override
    public Manufacturer findManufacturerById (Long id){

        return this.manufacturerRepository.getOne(id);
    }*/
}
