package com.hr.model;


import java.io.Serializable;
import java.util.Objects;

public class EmployeeData implements Serializable {
    private String employeeId;
    private String name;
    private String contractInfo;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(String contractInfo) {
        this.contractInfo = contractInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeData)) return false;
        EmployeeData that = (EmployeeData) o;
        return Objects.equals(getEmployeeId(), that.getEmployeeId()) && Objects.equals(getName(), that.getName()) && Objects.equals(getContractInfo(), that.getContractInfo()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmployeeId(), getName(), getContractInfo(), getStatus());
    }
}
