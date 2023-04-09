package com.example.mobile_labs_20521431;

import java.text.DecimalFormat;

public class GrossSalary {
    protected String _name;
    protected double _salary;

    public GrossSalary(String name, double salary)
    {
        this._name   = name;
        this._salary = salary;
    }



    public void SetName ()
    {
        this._name = _name;
    }
    public void SetSalary (double salary)
    {
        this._salary = salary;
    }
    public String GetName()
    {
        return _name;
    }
    public double GetSalary()
    {
        return _salary;
    }
    public String GetBoth()
    {   double Format = GetSalary();
        DecimalFormat df = new DecimalFormat("#,###.#");
        String DisplaySalary = df.format(Format);
        String temp = "Name: " + GetName() + "         "+ "Net Salary:" + DisplaySalary;
        return temp;
    }
    //hien thi thong tin in ra list view va format number hien thi luong
}
