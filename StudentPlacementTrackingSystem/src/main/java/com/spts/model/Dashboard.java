package com.spts.model;

public class Dashboard {

    private int totalCompanies;

    private int appliedCompanies;

    private int selectedCompanies;

    private int rejectedCompanies;

    public int getTotalCompanies() {
        return totalCompanies;
    }

    public void setTotalCompanies(int totalCompanies) {
        this.totalCompanies = totalCompanies;
    }

    public int getAppliedCompanies() {
        return appliedCompanies;
    }

    public void setAppliedCompanies(int appliedCompanies) {
        this.appliedCompanies = appliedCompanies;
    }

    public int getSelectedCompanies() {
        return selectedCompanies;
    }

    public void setSelectedCompanies(int selectedCompanies) {
        this.selectedCompanies = selectedCompanies;
    }

    public int getRejectedCompanies() {
        return rejectedCompanies;
    }

    public void setRejectedCompanies(int rejectedCompanies) {
        this.rejectedCompanies = rejectedCompanies;
    }
}