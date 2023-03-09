package com.example.MainMarcet.services;


import com.example.MainMarcet.models.Parser;
import com.example.MainMarcet.models.Post;
import com.example.MainMarcet.repo.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component
@AllArgsConstructor
@Slf4j
@EnableScheduling
public class updateDateBase {

    private PostRepository postRepository;
    private int QuantityCoin = 100;                                                                                     //количество монет при 1 запросе
    private int page = 0;                                                                                               //номер страницы гне находиться цена монет
    private int requestCoinGeCo = 10;                                                                                    //сколько выполнитть запросов по API


    @Autowired
    public updateDateBase(PostRepository postRepository) {                                                              //репозетория для сохранение или обновление обектов в базе данных
        this.postRepository = postRepository;
    }

    public Post saveDB(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }


    @Scheduled(fixedRate = 70000)
    public void update() {
        Parser parser = new Parser();
        List<Post> list = new ArrayList<>();
        List<Post> res = findAll();

        for (int i = 0; i < requestCoinGeCo; i++) {
            page = i + 1;

            String url = parser.getUrlContent(parser.urlCoinGeco("USD", QuantityCoin, page));
            JSONArray object = new JSONArray(url);

            for (int j = 0; j < object.length(); j++) {

                String data = object.get(j).toString();
                JSONObject jsonObject = new JSONObject(data);
                list.add(new Post(
                        jsonObject.get("market_cap_rank").toString(),
                        jsonObject.get("id").toString(),
                        jsonObject.get("current_price").toString(),
                        jsonObject.get("market_cap_change_percentage_24h").toString(),
                        jsonObject.get("total_volume").toString(),
                        jsonObject.get("market_cap").toString(),
                        jsonObject.get("image").toString()));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            updateDB(list.get(i), res.get(i));
        }
        list.clear();                                                                                                   //отчищаем списки что бы не создовались дубли
        res.clear();                                                                                                    //отчищаем списки что бы не создовались дубли
    }


    public void updateDB(Post posts, Post findByID) {

        Post post = findByID;
        post.setMarket_cap_rank(posts.getMarket_cap_rank());
        post.setIdName(posts.getIdName());
        post.setCurrent_price(posts.getCurrent_price());
        post.setMarket_cap_change_percentage_24h(posts.getMarket_cap_change_percentage_24h());
        post.setTotal_volume(posts.getTotal_volume());
        post.setMarket_cap(posts.getMarket_cap());
        post.setImage_coin(posts.getImage_coin());
        saveDB(post);

    }


}
