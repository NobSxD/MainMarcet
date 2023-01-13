package com.example.MainMarcet.controlers;

import com.example.MainMarcet.models.Post;
import com.example.MainMarcet.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControl {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "home";
    }
}
