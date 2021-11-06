package com.example.tp_chap6;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/")
public class MainController {

    @Autowired

    private  UserRep userRep;
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUser(){

        return userRep.findAll();
    }

    @PostMapping(path = "/add")
    public @ResponseBody String AddUser (@RequestParam String name , @RequestParam String email){
        User u = new User();
                u.setName(name);
                u.setEmail(email);
                userRep.save(u);
    return "Saved";
    }

    @Autowired
    private  GroupRep groupRep;
    @GetMapping(path = "/allg")
    public @ResponseBody Iterable<Group> getAllGroup(){

        return groupRep.findAll();
    }

}
