package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum DevelopmentalPlanType
{
    @JsonProperty("Mentoring")
    MENTORING,
    @JsonProperty("Course")
    COURSE,
    @JsonProperty("Workshop")
    WORKSHOP,
    @JsonProperty("Seminars")
    SEMINARS ;

}
