package at.ac.tgm.floodmonitor.model;

import java.time.LocalDateTime;

public class Measurement {

    private LocalDateTime timestamp;
    private double waterLevel;
    private double flowRate;
    private double rainfall;
    private double temperature;
    private double batteryLevel;
    private WarningLevel warningLevel;
    private StationStatus status;

    public Measurement() {
    }

    public Measurement(
            LocalDateTime timestamp,
            double waterLevel,
            double flowRate,
            double rainfall,
            double temperature,
            double batteryLevel,
            WarningLevel warningLevel,
            StationStatus status
    ) {
        this.timestamp = timestamp;
        this.waterLevel = waterLevel;
        this.flowRate = flowRate;
        this.rainfall = rainfall;
        this.temperature = temperature;
        this.batteryLevel = batteryLevel;
        this.warningLevel = warningLevel;
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public double getFlowRate() {
        return flowRate;
    }

    public void setFlowRate(double flowRate) {
        this.flowRate = flowRate;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(double batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public WarningLevel getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(WarningLevel warningLevel) {
        this.warningLevel = warningLevel;
    }

    public StationStatus getStatus(){
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }
}