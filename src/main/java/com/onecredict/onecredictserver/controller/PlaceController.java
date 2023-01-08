package com.onecredict.onecredictserver.controller;

import com.onecredict.onecredictserver.controller.rq.SavePlaceRq;
import com.onecredict.onecredictserver.controller.rs.FindPlaceByIdRs;
import com.onecredict.onecredictserver.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/api/place")
    public void savePlace(@Validated @RequestBody SavePlaceRq rq){

        placeService.savePlace(rq);
    }

    @GetMapping("/api/place/{place-id}")
    public FindPlaceByIdRs findPlaceById(@PathVariable("place-id") Long placeId){
        return placeService.findPlaceById(placeId);
    }



}