package com.romellbolton.jsonreadergson;

import java.util.List;

/**
 * Created by romellbolton on 4/9/18.
 */

public class Employee
{
    private String EmployeeName;
    private int EmployeeId;
    private List<String> Department;

    public Employee()
    {
        super();
    }
    public Employee(String employeeName, int employeeId, List department)
    {
        super();
        EmployeeName = employeeName;
        EmployeeId = employeeId;
        Department = department;
    }

    public String getEmployeeName()
    {
        return EmployeeName;
    }
    public void setEmployeeName(String employeeName)
    {
        EmployeeName = employeeName;
    }
    public int getEmployeeId()
    {
        return EmployeeId;
    }
    public void setEmployeeId(int employeeId)
    {
        EmployeeId = employeeId;
    }
    public List<String> getDepartment()
    {
        return Department;
    }
    public void setDepartment(List<String> department)
    {
        Department = department;
    }
}
