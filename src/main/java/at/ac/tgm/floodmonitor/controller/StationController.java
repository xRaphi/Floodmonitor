package at.ac.tgm.floodmonitor.controller;

import at.ac.tgm.floodmonitor.model.Station;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class StationController {

    @GetMapping
    public List<Station> getAllStations() {
        return List.of(
                new Station(1L, "Station Donau", "Wien"),
                new Station(2L, "Station March", "Gänserndorf"),
                new Station(3L, "Station Inn", "Innsbruck")
        );
    }
}