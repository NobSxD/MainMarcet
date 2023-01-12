package com.example.MainMarcet.controlers;


import com.example.MainMarcet.models.Parser;
import com.example.MainMarcet.models.Post;
import com.example.MainMarcet.repo.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class BlogController {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String blogMain(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("post", posts);
        return "home";
    }

    @GetMapping("/3")
    public String blogDetails(@PathVariable(value = "id") long id, Model module){
        Parser parser = new Parser();
        String url = parser.getUrlContent(parser.urlCoinGeco("USD", 100, 1));
        JSONArray object = new JSONArray(url);
        for (int i = 0; i < object.length(); i++) {
            String data = object.get(i).toString();
            JSONObject jsonObject = new JSONObject(data);
            postRepository.save(new Post(jsonObject.get("market_cap_rank").toString(), jsonObject.get("id").toString(),
                    jsonObject.get("current_price").toString(), jsonObject.get("market_cap_change_percentage_24h").toString(),
                    jsonObject.get("total_volume").toString(), jsonObject.get("market_cap").toString()));
        }
        return "home";

    }


}
