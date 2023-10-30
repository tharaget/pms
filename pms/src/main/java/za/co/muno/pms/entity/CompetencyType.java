package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CompetencyType
{
    PROCESS("Process"), CORE_MANAGEMENT("Core Management");

    public final String label;

    private CompetencyType(String label) {
        this.label = label;
    }
}
