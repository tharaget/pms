package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_developmental_plan")
public class DevelopmentalPlan
{

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private DevelopmentalPlanType type;

    private String targetedDate;

    public DevelopmentalPlan(String description, DevelopmentalPlanType type, String targetedDate, Contract contract) {
        this.description = description;
        this.type = type;
        this.targetedDate = targetedDate;
        this.contract = contract;
    }

    public DevelopmentalPlan() {
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DevelopmentalPlanType getType() {
        return type;
    }

    public void setType(DevelopmentalPlanType type) {
        this.type = type;
    }

    public String getTargetedDate() {
        return targetedDate;
    }

    public void setTargetedDate(String targetedDate) {
        this.targetedDate = targetedDate;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
