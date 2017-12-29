package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }




    @RequestMapping(value = "results", method = RequestMethod.GET)
    public String search(Model model,
                         @RequestParam("searchTerm") String searchTerm, @RequestParam("searchType") String searchType) {

        ArrayList<HashMap<String,String>> jobs; // list of 'jobs' AKA each job is a HashMap of data...


        model.addAttribute("headers", JobData.findAll().get(0).keySet() );

        if(searchType.equals("all"))
        {
            jobs = JobData.findByValue(searchTerm);
        }
        else
        {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }



        model.addAttribute("testdata", jobs);
        return "searchResults";
    }


    @RequestMapping(value = "results2" , method = RequestMethod.GET)
    public String listColumnValues2(Model model) {
        //model.addAttribute("columns", ListController.columnChoices);
        ArrayList<HashMap<String,String>> data = JobData.findByValue("java");
        ArrayList<String> jobData = new ArrayList<>();

        for( HashMap jobPair : data ) {
            System.out.println(jobPair);
            jobData.add(jobPair.get("employer").toString());
        }

        System.out.println(jobData.size());
        System.out.println(data.size());

        jobData.add("Green");
        jobData.add("red");
        jobData.add("alpha");
        jobData.add("stuff");
        model.addAttribute("testdata", jobData);
        return "searchResults";

    }



}
