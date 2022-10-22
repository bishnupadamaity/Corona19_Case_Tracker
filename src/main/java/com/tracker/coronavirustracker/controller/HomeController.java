package com.tracker.coronavirustracker.controller;

import com.tracker.coronavirustracker.Services.CoronaVirusDataService;
import com.tracker.coronavirustracker.model.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataService coronaVirusDataService;

    @RequestMapping("/")
    public String home(Model model){

        List<LocationStats> allStats= coronaVirusDataService.getAllStats();

        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("totalReportedCases",totalReportedCases);

        model.addAttribute("locationStats",allStats);

        return "index";
    }

}
