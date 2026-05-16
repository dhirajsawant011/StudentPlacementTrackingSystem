package com.spts.repository;

import java.sql.ResultSet;
import java.util.List;

import com.spts.model.Dashboard;
import com.spts.model.Placement;

public interface PlacementRepositoryInterface {

    public boolean applyCompany(int sid, int cid, String applyDate);
    public ResultSet getAppliedCompanies(int sid);
    public Dashboard getDashboardData(int sid);
    public ResultSet getAllApplications();
    public boolean updateStatus(int pid,String status);
    public int getTotalCompanies();
    public int getTotalStudents();
    public int getPlacedCount();
    public int getRejectedCount();   
}