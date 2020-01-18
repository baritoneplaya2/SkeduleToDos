package org.launchcode.SkeduleToDos.controllers;

import org.launchcode.SkeduleToDos.models.data.ToDosDao;
import org.launchcode.SkeduleToDos.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SkeduleToDosController{
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private ToDosDao toDosDao;
}
