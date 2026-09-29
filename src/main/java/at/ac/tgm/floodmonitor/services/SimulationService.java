package at.ac.tgm.floodmonitor.services;

import at.ac.tgm.floodmonitor.model.Measurement;
import at.ac.tgm.floodmonitor.model.StationStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SimulationService {

    private final List<Measurement> measurements = new ArrayList<>();

    @Scheduled(fixedRate = 10000)
    public void generateMeasurement() {

        double waterLevel = 2.0 + Math.random();

        Measurement measurement = new Measurement(
                LocalDateTime.now(),
                waterLevel,
                100 + Math.random() * 30,
                2 + Math.random() * 3,
                15 + Math.random() * 5,
                80 + Math.random() * 20,
                null,
                StationStatus.ONLINE
        );

        measurements.add(measurement);
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public Measurement getLatestMeasurement() {
        if (measurements.isEmpty()) {
            return null;
        }

        return measurements.get(measurements.size() - 1);
    }
}