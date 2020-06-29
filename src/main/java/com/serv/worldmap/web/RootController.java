package com.serv.worldmap.web;

import com.serv.worldmap.service.MagazineService;
import com.serv.worldmap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {
    @Autowired
    private UserService userService;

    @Autowired
    private MagazineService magazineService;

    @GetMapping("/")
    public String root(){return "index";}

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users",userService.getAll());
        return "users";
    }

    @GetMapping("/users")
    public String setUsers(HttpServletRequest request){
        int userId=Integer.parseInt(request.getParameter("userId"));
        SecurityUtil.setAuthUserId(userId);
        return "redirect:magazines";
    }

}
