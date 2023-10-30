package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tbl_key_results_areas_activity")
public class KeyResultsAreasActivity
{

    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private float target;
    private String indicator;

    private String targetDate;
    @Lob
    private String resourceRequired;
    @Lob
    private String enablingCondition;
    @ManyToOne
    @JoinColumn(name = "keyResultsAreas_id")
    @JsonIgnore
    private ContractKeyResultsAreas keyResultsAreas;

    public KeyResultsAreasActivity() {
    }

    public KeyResultsAreasActivity(String description, float target, String indicator, String targetDate, String resourceRequired, String enablingCondition, ContractKeyResultsAreas keyResultsAreas) {
        this.description = description;
        this.target = target;
        this.indicator = indicator;
        this.targetDate = targetDate;
        this.resourceRequired = resourceRequired;
        this.enablingCondition = enablingCondition;
        this.keyResultsAreas = keyResultsAreas;
    }

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

    public float getTarget() {
        return target;
    }

    public void setTarget(float target) {
        this.target = target;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }

    public String getResourceRequired() {
        return resourceRequired;
    }

    public void setResourceRequired(String resourceRequired) {
        this.resourceRequired = resourceRequired;
    }

    public String getEnablingCondition() {
        return enablingCondition;
    }

    public void setEnablingCondition(String enablingCondition) {
        this.enablingCondition = enablingCondition;
    }

    public ContractKeyResultsAreas getKeyResultsAreas() {
        return keyResultsAreas;
    }

    public void setKeyResultsAreas(ContractKeyResultsAreas keyResultsAreas) {
        this.keyResultsAreas = keyResultsAreas;
    }
}
