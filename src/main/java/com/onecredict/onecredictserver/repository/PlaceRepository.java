package com.onecredict.onecredictserver.repository;

import com.onecredict.onecredictserver.database.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
