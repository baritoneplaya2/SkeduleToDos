package org.launchcode.SkeduleToDos.controllers;

import org.launchcode.SkeduleToDos.models.ToDos;
import org.launchcode.SkeduleToDos.models.data.ToDosDao;
import org.launchcode.SkeduleToDos.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value="")
public class ToDosController {

    @Autowired
    private ToDosDao toDosDao;

    @Autowired
    private UsersDao usersDao;

    //    list view
    @RequestMapping(value="list")
    public String list(Model model, ToDos toDos) {
        model.addAttribute("title", "List");
        model.addAttribute("toDos", toDosDao.findAll());
        int toDosId = toDos.getId();
        return "/list";
    }

    //    add event view
    @RequestMapping(value="/add", method = RequestMethod.GET)
    public String add(Model model) {
        ToDos toDos = new ToDos();
        model.addAttribute("toDos", toDos);
        model.addAttribute("title", "ToDo");
        return "/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid ToDos toDos, Errors errors) {
        model.addAttribute(toDos);
        if (!errors.hasErrors()) {
            toDosDao.save(toDos);
            int id = toDos.getId();
            return "redirect:/list";
        }
        return "/add";
    }

}
