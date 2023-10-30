package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_contract_competency")
public class ContractCompetency
{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    @JsonIgnore
    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "competency_id")
    private GenericManagementCompetencies competency;

    public ContractCompetency() {
    }

    public ContractCompetency(Contract contract, GenericManagementCompetencies competency) {
        this.contract = contract;
        this.competency = competency;
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

    public GenericManagementCompetencies getCompetency() {
        return competency;
    }

    public void setCompetency(GenericManagementCompetencies competency) {
        this.competency = competency;
    }
}
