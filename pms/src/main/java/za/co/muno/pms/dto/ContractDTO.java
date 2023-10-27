package za.co.muno.pms.dto;

import org.apache.catalina.LifecycleState;
import za.co.muno.pms.entity.*;

import java.util.List;

public class ContractDTO
{
    private List<Contract> myContracts;
    private List<Contract> subordinatesContracts;
    private PMSStatus status;

    private Account account;
    private Long contractId;
    private Long genericManagementCompetenciesId;
    private Long contractCompetencyId;

    private Long contractKeyResultsAreasId;

    private Long keyResultsAreasActivityId;

    private Long developmentalPlanId;

    private DevelopmentalPlan developmentalPlan;

    private ContractCompetency contractCompetency;

    private ContractKeyResultsAreas keyResultsAreas;

    private KeyResultsAreasActivity activity;

    private String comment;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public Long getGenericManagementCompetenciesId() {
        return genericManagementCompetenciesId;
    }

    public void setGenericManagementCompetenciesId(Long genericManagementCompetenciesId) {
        this.genericManagementCompetenciesId = genericManagementCompetenciesId;
    }

    public ContractCompetency getContractCompetency() {
        return contractCompetency;
    }

    public void setContractCompetency(ContractCompetency contractCompetency) {
        this.contractCompetency = contractCompetency;
    }

    public Long getContractCompetencyId() {
        return contractCompetencyId;
    }

    public void setContractCompetencyId(Long contractCompetencyId) {
        this.contractCompetencyId = contractCompetencyId;
    }

    public Long getContractKeyResultsAreasId() {
        return contractKeyResultsAreasId;
    }

    public void setContractKeyResultsAreasId(Long contractKeyResultsAreasId) {
        this.contractKeyResultsAreasId = contractKeyResultsAreasId;
    }

    public Long getKeyResultsAreasActivityId() {
        return keyResultsAreasActivityId;
    }

    public void setKeyResultsAreasActivityId(Long keyResultsAreasActivityId) {
        this.keyResultsAreasActivityId = keyResultsAreasActivityId;
    }

    public Long getDevelopmentalPlanId() {
        return developmentalPlanId;
    }

    public void setDevelopmentalPlanId(Long developmentalPlanId) {
        this.developmentalPlanId = developmentalPlanId;
    }

    public ContractKeyResultsAreas getKeyResultsAreas() {
        return keyResultsAreas;
    }

    public void setKeyResultsAreas(ContractKeyResultsAreas keyResultsAreas) {
        this.keyResultsAreas = keyResultsAreas;
    }

    public KeyResultsAreasActivity getActivity() {
        return activity;
    }

    public void setActivity(KeyResultsAreasActivity activity) {
        this.activity = activity;
    }

    public DevelopmentalPlan getDevelopmentalPlan() {
        return developmentalPlan;
    }

    public void setDevelopmentalPlan(DevelopmentalPlan developmentalPlan) {
        this.developmentalPlan = developmentalPlan;
    }

    public PMSStatus getStatus() {
        return status;
    }

    public void setStatus(PMSStatus status) {
        this.status = status;
    }

    public List<Contract> getMyContracts() {
        return myContracts;
    }

    public void setMyContracts(List<Contract> myContracts) {
        this.myContracts = myContracts;
    }

    public List<Contract> getSubordinatesContracts() {
        return subordinatesContracts;
    }

    public void setSubordinatesContracts(List<Contract> subordinatesContracts) {
        this.subordinatesContracts = subordinatesContracts;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
