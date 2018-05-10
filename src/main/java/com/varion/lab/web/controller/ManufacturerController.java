package com.varion.lab.web.controller;

import com.varion.lab.model.Manufacturer;
import com.varion.lab.service.CategoryService;
import com.varion.lab.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/emt/lab")
public class ManufacturerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;


    @GetMapping("/manufacturer/add")
    public String addManufacturer(Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        model.addAttribute("manufacturer", new Manufacturer());
        return "forms/manufacturer.Add";
    }

    @PostMapping(value= "/manufacturer/manufacturer-saved")
    public String saveManufacturer(@ModelAttribute String name, Model model) {
        model.addAttribute("categories", categoryService.findAllCategories());
        manufacturerService.saveManufacturer(name);
        return "common/success";
    }


}
