package at.ac.tgm.floodmonitor.controller;

import at.ac.tgm.floodmonitor.model.Measurement;
import at.ac.tgm.floodmonitor.services.SimulationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stations")
public class MeasurementController {

    private final SimulationService simulationService;

    public MeasurementController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/{stationId}/measurements/latest")
    public Measurement getLatestMeasurement() {
        return simulationService.getLatestMeasurement();
    }

    @GetMapping("/{stationId}/measurements")
    public List<Measurement> getMeasurements() {
        return simulationService.getMeasurements();
    }
}