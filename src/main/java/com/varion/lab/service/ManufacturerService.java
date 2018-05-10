package com.varion.lab.service;

import com.varion.lab.model.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    Manufacturer saveManufacturer (String name);
    List<Manufacturer> findAllManufacturers();
  //  Manufacturer findManufacturerById (Long id);
}
