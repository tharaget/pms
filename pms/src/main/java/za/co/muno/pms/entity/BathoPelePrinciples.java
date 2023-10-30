package za.co.muno.pms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "tbl_batho_pele_principles")
public class BathoPelePrinciples
{
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public BathoPelePrinciples(String name) {
        this.name = name;
    }

    public BathoPelePrinciples() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BathoPelePrinciples{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
