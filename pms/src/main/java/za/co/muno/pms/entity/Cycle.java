package za.co.muno.pms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tbl_cycle")
public class Cycle
{

    @Id
    @GeneratedValue
    private Long id;
    private int year;
    private boolean allowCreate;

    public Cycle(int year, boolean allowCreate) {
        this.year = year;
        this.allowCreate = allowCreate;
    }

    public Cycle() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAllowCreate() {
        return allowCreate;
    }

    public void setAllowCreate(boolean allowCreate) {
        this.allowCreate = allowCreate;
    }

}
