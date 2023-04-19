package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.services.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @GetMapping
    public void fetchAllData() {
        loadService.fetchAllDataFromApi();
    }
}
