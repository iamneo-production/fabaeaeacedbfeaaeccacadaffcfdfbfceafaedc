package com.examly.springapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.examly.springapp.dao.UserDAO;

import com.examly.springapp.model.User;

@Controller
public class hello {

    @Autowired
    UserDAO userdao;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/saveTask")
    public String saveTask(User user) {
        userdao.save(user);
        return "index";
    }

    @RequestMapping(value = "/allTask", method = RequestMethod.GET)
    public ModelAndView findAllUsers(ModelAndView mav) {
        List<User> users = userdao.findAll();
        mav.addObject("users", users);
        mav.setViewName("getData");
        return mav;
    }

    @RequestMapping("/getTask")
    public ModelAndView getuser(@RequestParam int id) {

        ModelAndView mav = new ModelAndView("showUser");
        User user = userdao.findById(id).orElse(new User());
        mav.addObject(user);
        return mav;
    }

    @RequestMapping("/changeStatus")
    public ModelAndView updateuser(User user) {

        ModelAndView mav = new ModelAndView("updateUser");
        user = userdao.findById(user.getTaskId()).orElse(new User());
        userdao.deleteById(user.getTaskId());
        mav.addObject(user);
        return mav;
    }

    @RequestMapping("/deleteTask")
    public ModelAndView deleteuser(@RequestParam int id) {

        ModelAndView mav = new ModelAndView("deleteUser");
        User user = userdao.findById(id).orElse(new User());
        userdao.deleteById(id);
        mav.addObject(user);
        return mav;
    }

     @PostMapping("/saveTask")
     public String addur(@RequestBody User user) {
     userdao.save(user);
     return "index";
     }
     
     @GetMapping("/alltasks")
     public List<User> getuser() {
     return userdao.findAll();
     }
     
     @GetMapping("/getTask/{id}")
     
     public User getUserById(@PathVariable Integer id) {
     User user = userdao.findById(id).orElse(new User());
     return user;
     }
     
     @GetMapping("/deleteTask/{id}")
     
     public String deleteUser(@PathVariable Integer id) {
     User user = userdao.findById(id).orElse(new User());
     userdao.delete(user);
     return "deleted";
     }
}
