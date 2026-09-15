package at.ac.tgm.floodmonitor.services;

import at.ac.tgm.floodmonitor.model.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    public List<Station> getAllStations() {
        return List.of(
                new Station(1L, "Station Donau", "Wien"),
                new Station(2L, "Station March", "Gänserndorf"),
                new Station(3L, "Station Inn", "Innsbruck")
        );
    }
}