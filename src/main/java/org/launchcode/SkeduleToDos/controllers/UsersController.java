package org.launchcode.SkeduleToDos.controllers;

import org.launchcode.SkeduleToDos.models.Users;
import org.launchcode.SkeduleToDos.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class UsersController {

    @Autowired
    private UsersDao usersDao;

    //    welcome/index page
    @RequestMapping(value="")
    public String index() {
        return "/index";
    }

    //    register page
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register(Model model) {
        Users users = new Users();
        model.addAttribute("users", users);
        model.addAttribute("title", "Register");
        return "/register";
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute @Valid Users users, Errors errors, String verify) {
        model.addAttribute(users);
        if (!errors.hasErrors()) {
            usersDao.save(users);
            int id = users.getId();
            return "redirect:/list";
        }
        return "/register";
    }

    //    login page
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("title", "Login");
        return "/login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(Model model, @RequestParam String email, @RequestParam String password) {
        if (email != "" && password != "") {
            Users founduser = usersDao.findByEmail(email);
            if (password.equals(founduser.getPassword())) {
                return "redirect:/list";
            }
        }
        return "/login";
    }

}
