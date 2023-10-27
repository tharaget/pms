package za.co.muno.pms.dto;

import za.co.muno.pms.entity.Contract;
import za.co.muno.pms.entity.IndividualKPA;

public class KPADTO
{
    private IndividualKPA kpa;
    private Long contractId;


    public IndividualKPA getKpa() {
        return kpa;
    }

    public void setKpa(IndividualKPA kpa) {
        this.kpa = kpa;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
