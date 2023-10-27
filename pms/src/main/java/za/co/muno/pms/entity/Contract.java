package za.co.muno.pms.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_contract")
public class Contract
{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Enumerated(EnumType.STRING)
    private PMSStatus status;
    @ManyToOne
    @JoinColumn(name = "cycle_id")
    private Cycle cycle;
    @OneToMany(mappedBy = "contract")
    private List<IndividualKPA> kpas;
    @OneToMany(mappedBy = "contract")
    private List<ContractCompetency> contractCompetencies;
    @OneToMany(mappedBy = "contract")
    private List<ContractKeyResultsAreas> keyResultsAreas;
    @OneToMany(mappedBy = "contract")
    private List<DevelopmentalPlan> developmentalPlans;
    @OneToMany(mappedBy = "contract")
    private List<Note> notes;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }




    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }
    public List<IndividualKPA> getKpas() {
        return kpas;
    }

    public void setKpas(List<IndividualKPA> kpas) {
        this.kpas = kpas;
    }

    public PMSStatus getStatus() {
        return status;
    }

    public void setStatus(PMSStatus status) {
        this.status = status;
    }

    public List<ContractCompetency> getContractCompetencies() {
        return contractCompetencies;
    }

    public void setContractCompetencies(List<ContractCompetency> contractCompetencies) {
        this.contractCompetencies = contractCompetencies;
    }

    public List<ContractKeyResultsAreas> getKeyResultsAreas() {
        return keyResultsAreas;
    }

    public void setKeyResultsAreas(List<ContractKeyResultsAreas> keyResultsAreas) {
        this.keyResultsAreas = keyResultsAreas;
    }

    public List<DevelopmentalPlan> getDevelopmentalPlans() {
        return developmentalPlans;
    }

    public void setDevelopmentalPlans(List<DevelopmentalPlan> developmentalPlans) {
        this.developmentalPlans = developmentalPlans;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", createdDate=" + createdDate +
                ", status=" + status +
                ", cycle=" + cycle +
                ", kpas=" + kpas +
                ", contractCompetencies=" + contractCompetencies +
                ", keyResultsAreas=" + keyResultsAreas +
                ", developmentalPlans=" + developmentalPlans +
                ", notes=" + notes +
                '}';
    }
}
