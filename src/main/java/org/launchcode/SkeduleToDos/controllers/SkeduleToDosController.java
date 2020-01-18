package org.launchcode.SkeduleToDos.controllers;

import org.launchcode.SkeduleToDos.models.data.UsersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SkeduleToDosController<EventsDao> {
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private EventsDao eventsDao;
}
