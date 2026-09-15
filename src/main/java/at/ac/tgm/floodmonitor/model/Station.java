package at.ac.tgm.floodmonitor.model;

public class Station {

    private Long id;
    private String name;
    private String location;
    private StationStatus status;

    public Station() {
    }

    public Station(Long id, String name, String location, StationStatus status) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StationStatus getStatus() {
        return status;
    }

    public void setStatus(StationStatus status) {
        this.status = status;
    }
}