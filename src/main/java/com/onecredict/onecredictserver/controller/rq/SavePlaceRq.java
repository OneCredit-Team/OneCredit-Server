package com.onecredict.onecredictserver.controller.rq;

import lombok.Getter;

@Getter
public class SavePlaceRq {
    private String name;
    private String address;
    private Integer maxPeople;
}
