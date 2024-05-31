package by.VIWARR.TheFinalProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Поле имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя должно быть от 2 до 30 символов")
    private String name;

    @Column(name = "password")
    @Size(min = 8, max = 100, message = "Пароль должен быть от 8 символов")
    private String password;

    @Column(name = "description")
    private String description;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "company")
    private Tender tenders;

    public Company() {}

    public Company(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
        this.role = "ROLE_USER";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Tender getTenders() {
        return tenders;
    }

    public void setTenders(Tender tenders) {
        this.tenders = tenders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
