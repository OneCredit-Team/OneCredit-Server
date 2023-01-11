package com.onecredict.onecredictserver.controller.rs;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindPlaceByIdRs {
    private Long id;
    private String name;
    private String address;
    private Integer maxPeople;
}
