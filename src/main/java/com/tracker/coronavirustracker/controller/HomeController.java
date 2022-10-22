package com.tracker.coronavirustracker.controller;

import com.tracker.coronavirustracker.Services.CoronaVirusDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @RequestMapping("/")
    public String home(Model model){

        model.addAttribute("locationStats",coronaVirusDataService.getAllStats());

        return "index";
    }

}
