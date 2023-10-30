package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table( name = "tbl_kpa_batho_pele_principles")
public class KPABathoPelePrinciples
{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "batho_pele_principles_id")
    private BathoPelePrinciples bathoPelePrinciples;
    @ManyToOne
    @JoinColumn(name = "kpa_id")
    @JsonIgnore
    private IndividualKPA kpa;


    public KPABathoPelePrinciples() {
    }

    public KPABathoPelePrinciples(BathoPelePrinciples bathoPelePrinciples, IndividualKPA kpa) {
        this.bathoPelePrinciples = bathoPelePrinciples;
        this.kpa = kpa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BathoPelePrinciples getBathoPelePrinciples() {
        return bathoPelePrinciples;
    }

    public void setBathoPelePrinciples(BathoPelePrinciples bathoPelePrinciples) {
        this.bathoPelePrinciples = bathoPelePrinciples;
    }

    public IndividualKPA getKpa() {
        return kpa;
    }

    public void setKpa(IndividualKPA kpa) {
        this.kpa = kpa;
    }
}
