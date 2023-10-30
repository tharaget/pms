package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_individual_kpa")
public class IndividualKPA {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "kpa", cascade = CascadeType.ALL)
    private List<KPABathoPelePrinciples> kpaBathoPelePrinciples;

    public IndividualKPA() {

    }

    public IndividualKPA(String name, int weight, Date createdDate, Contract contract) {
        this.name = name;
        this.weight = weight;
        this.createdDate = createdDate;
        this.contract = contract;
    }

    private int weight;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    @JsonIgnore
    private Contract contract;

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

    public List<KPABathoPelePrinciples> getKpaBathoPelePrinciples() {
        return kpaBathoPelePrinciples;
    }

    public void setKpaBathoPelePrinciples(List<KPABathoPelePrinciples> kpaBathoPelePrinciples) {
        this.kpaBathoPelePrinciples = kpaBathoPelePrinciples;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "IndividualKPA{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", kpaBathoPelePrinciples=" + kpaBathoPelePrinciples +
                ", weight=" + weight +
                ", createdDate=" + createdDate +
                '}';
    }
}
