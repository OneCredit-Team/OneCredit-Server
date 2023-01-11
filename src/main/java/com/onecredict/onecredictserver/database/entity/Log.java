package com.onecredict.onecredictserver.database.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private Long id;

    private Long placeId;
    private Integer currentPeople;
    private String time;
    private String date;
    private String day;

    public static Log create(Long placeId, Integer currentPeople, String time, String date, String day) {
        Place place = new Place();
        Log log = new Log();
        log.placeId = placeId;
        log.currentPeople = currentPeople;
        log.time = time;
        log.date = date;
        log.day = day;
        return log;
    }
}
