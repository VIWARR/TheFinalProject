package by.VIWARR.TheFinalProject.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Varieties")
public class Variety {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "variety")
    private List<Tender> tenders;

    public Variety() {}

    public Variety(Product product, String name) {
        this.product = product;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tender> getTenders() {
        return tenders;
    }

    public void setTenders(List<Tender> tenders) {
        this.tenders = tenders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variety variety = (Variety) o;
        return id == variety.id && Objects.equals(product, variety.product) && Objects.equals(name, variety.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, name);
    }

    @Override
    public String toString() {
        return "Variety{" +
                "id=" + id +
                ", product=" + product +
                ", name='" + name + '\'' +
                ", tenders=" + tenders +
                '}';
    }
}