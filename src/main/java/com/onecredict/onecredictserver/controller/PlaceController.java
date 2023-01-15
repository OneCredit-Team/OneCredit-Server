package com.onecredict.onecredictserver.controller;

import com.onecredict.onecredictserver.controller.rq.SavePlaceRq;
import com.onecredict.onecredictserver.controller.rs.FindAllPlaceRs;
import com.onecredict.onecredictserver.controller.rs.FindPlaceByAddressRs;
import com.onecredict.onecredictserver.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.onecredict.onecredictserver.repository.CsvRepository.ConvertCsvtoJson;
@CrossOrigin(origins="*", allowedHeaders = "*")
@RequiredArgsConstructor
@RestController
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping("/api/place/all")
    public List<FindAllPlaceRs> findAllPlace(){
        return placeService.findAllPlace();
    }

    @PostMapping("/api/place/add")
    public void savePlace(@Validated @RequestBody SavePlaceRq rq){
        placeService.savePlace(rq);
    }

    @GetMapping("/api/place/{address}")
    public FindPlaceByAddressRs findPlaceByAddress(@PathVariable("address") String address){
        return placeService.findPlaceByAddress(address);
    }
    @GetMapping("/pyData")
    public String showJson() throws Exception {return ConvertCsvtoJson();}
}