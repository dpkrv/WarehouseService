package models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_movement")
public class ProductMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "logistics_id")
    private Logistics logistics;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Date movementDate;

    public ProductMovement() {}
    public ProductMovement(Product product, Logistics logistics, Client client, Date movementDate) {
        this.product = product;
        this.logistics = logistics;
        this.client = client;
        this.movementDate = movementDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
    public Logistics getLogistics() { return logistics; }
    public void setLogistics(Logistics logistics) { this.logistics = logistics; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public Date getMovementDate() { return movementDate; }
    public void setMovementDate(Date movementDate) { this.movementDate = movementDate; }
}
