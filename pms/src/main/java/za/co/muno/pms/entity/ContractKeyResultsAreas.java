package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_contract_key_results_areas")
public class ContractKeyResultsAreas
{
    @Id
    @GeneratedValue
    private Long id;
    @Lob
    private String description;
    @ManyToOne
    @JoinColumn(name = "contract_id")
    @JsonIgnore
    private Contract contract;

    @OneToMany(mappedBy = "keyResultsAreas", cascade = CascadeType.ALL)
    private List<KeyResultsAreasActivity> activities;

    public ContractKeyResultsAreas(String description, Contract contract) {
        this.description = description;
        this.contract = contract;
    }

    public ContractKeyResultsAreas() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public List<KeyResultsAreasActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<KeyResultsAreasActivity> activities) {
        this.activities = activities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
