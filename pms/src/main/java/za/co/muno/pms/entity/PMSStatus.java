package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public enum PMSStatus {
    @JsonProperty("Saved")
    SAVED,
    @JsonProperty("Submitted to Supervisor")
    MANAGER,
    @JsonProperty("Approved by Supervisor")
    APPROVED;

}
