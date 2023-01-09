package com.onecredict.onecredictserver.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    private String name;

    private String address;

    private Integer maxPeople;

    public static Place create(String name, String address, Integer maxPeople) {
        Place place = new Place();
        place.name = name;
        place.address = address;
        place.maxPeople = maxPeople;
        return place;
    }
}
