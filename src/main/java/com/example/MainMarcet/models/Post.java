package com.example.MainMarcet.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_seq")
    @Column(name = "id", nullable = false)
    private Long id;


    private String market_cap_rank, idName, current_price,market_cap_change_percentage_24h,  total_volume, market_cap;


    public Post(String market_cap_rank, String idName, String current_price, String market_cap_change_percentage_24h, String total_volume, String market_cap) {
        this.market_cap_rank = market_cap_rank;
        this.idName = idName;
        this.current_price = current_price;
        this.market_cap_change_percentage_24h = market_cap_change_percentage_24h;
        this.total_volume = total_volume;
        this.market_cap = market_cap;
    }



}
