package at.ac.tgm.floodmonitor.services;

import at.ac.tgm.floodmonitor.model.Station;
import at.ac.tgm.floodmonitor.model.StationStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    private final List<Station> stations = List.of(
            new Station(1L, "Station Donau", "Wien", StationStatus.ONLINE),
            new Station(2L, "Station March", "Gänserndorf", StationStatus.MAINTENANCE),
            new Station(3L, "Station Inn", "Innsbruck", StationStatus.ONLINE)
    );

    public List<Station> getAllStations() {
        return stations;
    }

    public Station getStationById(Long id) {
        return stations.stream()
                .filter(station -> station.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}