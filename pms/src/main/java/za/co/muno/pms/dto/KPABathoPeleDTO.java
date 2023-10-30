package za.co.muno.pms.dto;

import za.co.muno.pms.entity.BathoPelePrinciples;
import za.co.muno.pms.entity.IndividualKPA;

public class KPABathoPeleDTO
{
    private IndividualKPA kpa;
    private Long bathoPelePrinciplesId;

    public IndividualKPA getKpa() {
        return kpa;
    }

    public void setKpa(IndividualKPA kpa) {
        this.kpa = kpa;
    }

    public Long getBathoPelePrinciplesId() {
        return bathoPelePrinciplesId;
    }

    public void setBathoPelePrinciplesId(Long bathoPelePrinciplesId) {
        this.bathoPelePrinciplesId = bathoPelePrinciplesId;
    }
}
