package at.ac.tgm.floodmonitor.controller;

import at.ac.tgm.floodmonitor.model.Measurement;
import at.ac.tgm.floodmonitor.model.WarningLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class MeasurementController {

    @GetMapping("/{stationId}/measurements/latest")
    public Measurement getLatestMeasurement() {
        return new Measurement(
                LocalDateTime.now(),
                2.35,
                120.5,
                4.2,
                18.6,
                87.0,
                WarningLevel.NORMAL
        );
    }

    @GetMapping("/{stationId}/measurements")
    public List<Measurement> getMeasurements() {
        return List.of(
                new Measurement(
                        LocalDateTime.now().minusHours(2),
                        2.10,
                        110.2,
                        2.5,
                        17.8,
                        89.0,
                        WarningLevel.NORMAL
                ),
                new Measurement(
                        LocalDateTime.now().minusHours(1),
                        2.25,
                        115.8,
                        3.1,
                        18.2,
                        88.0,
                        WarningLevel.NORMAL
                ),
                new Measurement(
                        LocalDateTime.now(),
                        2.35,
                        120.5,
                        4.2,
                        18.6,
                        87.0,
                        WarningLevel.NORMAL
                )
        );
    }
}