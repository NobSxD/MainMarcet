package com.example.MainMarcet.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    private String market_cap_rank, idName, current_price,market_cap_change_percentage_24h,  total_volume, market_cap, image_coin;

    public Post(String market_cap_rank, String idName, String current_price, String market_cap_change_percentage_24h, String total_volume, String market_cap, String image_coin) {
        this.market_cap_rank = market_cap_rank;
        this.idName = idName;
        this.current_price = current_price;
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
        this.total_volume = total_volume;
        this.market_cap = market_cap;
        this.image_coin = image_coin;
    }
}
