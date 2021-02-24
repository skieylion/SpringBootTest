package com.testboot.test1.controllers;

import com.testboot.test1.models.TestUser;
import com.testboot.test1.repo.TestUserRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private TestUserRepository testUserRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Главная страница");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "О нас");
        Iterable<TestUser> testUsers = testUserRepository.findAll();
        model.addAttribute("testUsers", testUsers);
        return "about";
    }
    @GetMapping("/blog-main")
    public String blog_main(Model model) {
        model.addAttribute("title", "Мой блог");
        return "blog-main";
    }

    @PostMapping("/blog-add")
    public String blog_add(
        @RequestParam String login,
        @RequestParam String name,
        @RequestParam String surname,
        @RequestParam String email,
        Model model)
    {
        TestUser user=new TestUser();
        user.setLogin(login);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPassword("testpassword");
        testUserRepository.save(user);

        return "redirect:user/"+login; //"redirect:/user"; // "user/"+login
    }
    @GetMapping("/user/{login}")
    public String user(
            @PathVariable(value="login") String login,
            Model model)
    {
        if(!testUserRepository.existsById(login)) {
            return "redirect:/";
        }
        Optional<TestUser> testUser=testUserRepository.findById(login);

        ArrayList<TestUser> listUser=new ArrayList<>();
        testUser.ifPresent(listUser::add);
        model.addAttribute("testUser",listUser);

        return "user";
    }
    @GetMapping("/user/edit")
    public String user_edit(
            @RequestParam String login,
            Model model)
    {
        TestUser testUser=testUserRepository.findById(login).get();
        model.addAttribute("testUser",testUser);

        return "edit";
    }
    @GetMapping("/user/delete")
    public String user_delete(
            @RequestParam String login,
            Model model)
    {
        testUserRepository.deleteById(login);
        return "redirect:/about";
    }
}
