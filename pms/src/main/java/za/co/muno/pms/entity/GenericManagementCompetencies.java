package za.co.muno.pms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_generic_management_competencies")
public class GenericManagementCompetencies
{

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private CompetencyType type;
    private String name;

    public GenericManagementCompetencies(CompetencyType type, String name) {
        this.type = type;
        this.name = name;
    }

    public GenericManagementCompetencies() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public CompetencyType getType() {
        return type;
    }

    public void setType(CompetencyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
