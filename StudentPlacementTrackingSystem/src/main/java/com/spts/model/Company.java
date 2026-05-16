package com.spts.model;

public class Company {

    private int id;
    private String companyName;
    private String packageName;
    private String location;
    private String criteria;

    public Company() {

    }

    public Company(String companyName,
                   String packageName,
                   String location,
                   String criteria) {

        this.companyName = companyName;
        this.packageName = packageName;
        this.location = location;
        this.criteria = criteria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}