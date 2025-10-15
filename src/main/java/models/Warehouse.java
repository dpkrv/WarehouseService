package models;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String location;

    public Warehouse() {}
    public Warehouse(String location) {
        this.location = location;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}