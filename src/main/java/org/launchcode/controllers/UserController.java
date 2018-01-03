package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.Cheese;
import org.launchcode.models.Menu;
import org.launchcode.models.User;
import org.launchcode.models.data.UserDao;
import org.launchcode.models.forms.AddMenuItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("usersList", userDao.findAll());
        System.out.println("***********************");
        for ( User U: userDao.findAll() ) {
            System.out.println(U.getUsername());
            System.out.println("***********************");
        }
        System.out.println(userDao.findAll());
        System.out.println("***********************");
        model.addAttribute("title", "The Users");

        return "user/index";
    }
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute @Valid User newUser, Errors errors, Model model) {

        System.out.println("=====");

        if(userDao.findByusername(newUser.getUsername()).size() > 0)
        {
            errors.rejectValue("username", null, null, "User name already used");

        }

        System.out.println("=====");


        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add";
        }
        userDao.save(newUser);
        return "redirect:";
    }
}