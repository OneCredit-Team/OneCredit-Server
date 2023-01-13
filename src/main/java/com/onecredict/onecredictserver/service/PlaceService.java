package com.onecredict.onecredictserver.service;

import com.onecredict.onecredictserver.controller.rq.SavePlaceRq;
import com.onecredict.onecredictserver.controller.rs.FindAllPlaceRs;
import com.onecredict.onecredictserver.controller.rs.FindPlaceByAddressRs;
import com.onecredict.onecredictserver.database.entity.Place;
import com.onecredict.onecredictserver.exception.CannotFindPlaceException;
import com.onecredict.onecredictserver.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PlaceService {

    private final PlaceRepository placeRepository;
    public void savePlace(SavePlaceRq rq) {
        Place place = Place.create(
                rq.getName(),
                rq.getAddress(),
                rq.getMaxPeople());
        placeRepository.save(place);
    }

    public FindPlaceByAddressRs findPlaceByAddress(String address) {
        Place place = this.findByAddress(address);

        return FindPlaceByAddressRs.builder()
                .id(place.getId())
                .name(place.getName())
                .address(place.getAddress())
                .maxPeople(place.getMaxPeople())
                .build();
    }

    public Place findByAddress(String address){
        return placeRepository.findFirstByAddress(address)
                .orElseThrow(CannotFindPlaceException::new);
    }

    public List<FindAllPlaceRs> findAllPlace(){
        return placeRepository.findAll().stream()
                .map(it -> FindAllPlaceRs.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .address(it.getAddress())
                        .maxPeople(it.getMaxPeople())
                        .build())
                .collect(Collectors.toList());
    }

    public Place findPlace(){
        return null;
    }
}
