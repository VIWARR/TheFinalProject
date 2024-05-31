package by.VIWARR.TheFinalProject.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Tenders")
public class Tender {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "variety_id", referencedColumnName = "id")
    private Variety variety;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    public Tender() {}

    public Tender(Product product, Variety variety, Company company) {
        this.product = product;
        this.variety = variety;
        this.company = company;
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

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tender tender = (Tender) o;
        return id == tender.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tender{" +
                "id=" + id +
                ", product=" + product +
                ", variety=" + variety +
                ", company=" + company +
                '}';
    }
}
