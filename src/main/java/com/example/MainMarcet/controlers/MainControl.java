package com.example.MainMarcet.controlers;

import com.example.MainMarcet.models.Post;
import com.example.MainMarcet.repo.PostRepository;
import com.example.MainMarcet.services.updateDateBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class MainControl {
    @Autowired
    private updateDateBase updateDateBase;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = updateDateBase.findAll();
        model.addAttribute("post", posts);

        return "home";
    }
    @GetMapping("/home")
    public String home1(Model model) {
        List<Post> posts = updateDateBase.findAll();
        model.addAttribute("post", posts);

        return "home";
    }

    @GetMapping("/1")
    public String one(Model model) {
        return "test";
    }

    @GetMapping("/update")
    public String update() {
    updateDateBase.update();
        return "redirect:/home";
    }
    @GetMapping("/admin")
    public String save(Model model) {
        updateDateBase.save();

        return "redirect:/home";
    }



}
