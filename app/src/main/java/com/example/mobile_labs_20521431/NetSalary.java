package com.example.mobile_labs_20521431;

public class NetSalary extends GrossSalary {

    public NetSalary(String name, double salary) {
        super(name, salary);

    }


    public void CalculateButton() {
        double a, tax;

        tax = (this._salary - 11000000) * 0.05;
        a = this._salary * 0.895;

        if (a <= 11000000) {
            SetSalary(a);
        } else {
            SetSalary(a-tax);
        }
    }
//ham xu ly so lieu luong khi nhan nut cal

}
