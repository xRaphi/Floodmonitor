package at.ac.tgm.floodmonitor.services;

import at.ac.tgm.floodmonitor.model.Station;
import at.ac.tgm.floodmonitor.model.StationStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    private final List<Station> stations = new ArrayList<>(List.of(
            new Station(1L, "Station Donau", "Wien", StationStatus.ONLINE),
            new Station(2L, "Station March", "Gänserndorf", StationStatus.MAINTENANCE),
            new Station(3L, "Station Inn", "Innsbruck", StationStatus.ONLINE)
    ));

    public List<Station> getAllStations() {
        return stations;
    }

    public Station getStationById(Long id) {
        return stations.stream()
                .filter(station -> station.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public int getStationCount() {
        return stations.size();
    }

    private long nextId = 4L;   //neue Stationen erhalten mind. die ID 4, weil 1-3 schon existieren.

    public synchronized Station addStation(Station station) {   //synchronized verhindert, dass zwei gleichzeitige Aufrufe dieselbe ID vergeben
        station.setId(nextId++);
        stations.add(station);
        return station;
    }

}