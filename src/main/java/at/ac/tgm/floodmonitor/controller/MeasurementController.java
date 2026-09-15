package at.ac.tgm.floodmonitor.controller;
import at.ac.tgm.floodmonitor.model.StationStatus;
import at.ac.tgm.floodmonitor.model.Measurement;
import at.ac.tgm.floodmonitor.model.WarningLevel;
import at.ac.tgm.floodmonitor.services.WarningLevelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class MeasurementController {

    private final WarningLevelService warningLevelService;

    public MeasurementController(WarningLevelService warningLevelService) {
        this.warningLevelService = warningLevelService;
    }

    @GetMapping("/{stationId}/measurements/latest")
    public Measurement getLatestMeasurement() {

        double waterLevel = 2.35;

        return new Measurement(
                LocalDateTime.now(),
                waterLevel,
                120.5,
                4.2,
                18.6,
                87.0,
                warningLevelService.calculateWarningLevel(waterLevel),
                StationStatus.ONLINE
        );
    }

    @GetMapping("/{stationId}/measurements")
    public List<Measurement> getMeasurements() {

        double waterLevel1 = 2.10;
        double waterLevel2 = 2.25;
        double waterLevel3 = 2.35;

        return List.of(
                new Measurement(
                        LocalDateTime.now().minusHours(2),
                        waterLevel1,
                        110.2,
                        2.5,
                        17.8,
                        89.0,
                        warningLevelService.calculateWarningLevel(waterLevel1),
                        StationStatus.ONLINE
                ),
                new Measurement(
                        LocalDateTime.now().minusHours(1),
                        waterLevel2,
                        115.8,
                        3.1,
                        18.2,
                        88.0,
                        warningLevelService.calculateWarningLevel(waterLevel2),
                        StationStatus.ONLINE
                ),
                new Measurement(
                        LocalDateTime.now(),
                        waterLevel3,
                        120.5,
                        4.2,
                        18.6,
                        87.0,
                        warningLevelService.calculateWarningLevel(waterLevel3),
                        StationStatus.ONLINE
                )
        );
    }
}