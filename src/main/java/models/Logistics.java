package models;

public class Logistics {
    private int id;
    private String location;
    private String transportType;

    public Logistics() {}
    public Logistics(int id, String location, String transportType) {
        this.id = id;
        this.location = location;
        this.transportType = transportType;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getTransportType() { return transportType; }
    public void setTransportType(String transportType) { this.transportType = transportType; }
}