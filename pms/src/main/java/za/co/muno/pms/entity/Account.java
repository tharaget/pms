package za.co.muno.pms.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_account")
public class Account
{

    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String employeeNames;

    private String personalNumber;

    private String branchName;
    private String jobTitle;
    private String province;
    @Lob
    private String jobPurpose;
    private String  supervisor;

    private String  supervisorPersonalNumber;



    public Account(String username, String password, String employeeNames) {
        this.username = username;
        this.password = password;
        this.employeeNames = employeeNames;
    }

    public Account() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeNames() {
        return employeeNames;
    }

    public void setEmployeeNames(String employeeNames) {
        this.employeeNames = employeeNames;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getJobPurpose() {
        return jobPurpose;
    }

    public void setJobPurpose(String jobPurpose) {
        this.jobPurpose = jobPurpose;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisorPersonalNumber() {
        return supervisorPersonalNumber;
    }

    public void setSupervisorPersonalNumber(String supervisorPersonalNumber) {
        this.supervisorPersonalNumber = supervisorPersonalNumber;
    }
}
