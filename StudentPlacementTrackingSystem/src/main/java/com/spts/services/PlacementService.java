package com.spts.services;

import java.sql.ResultSet;
import com.spts.model.*;

import com.spts.model.Dashboard;
import com.spts.repository.PlacementRepository;
import java.util.List;
import java.sql.ResultSet;


public class PlacementService implements PlacementServiceInterface 
{
	PlacementRepository repo =  new PlacementRepository();
    public boolean applyCompany(int sid, int cid, String applyDate)
    {
        return repo.applyCompany(sid,cid, applyDate);
    }
    
    public ResultSet getAppliedCompanies(int sid)
    {
        return repo.getAppliedCompanies(sid);
    }
    public Dashboard getDashboardData(int sid)
    {
        return repo.getDashboardData(sid);
    }
    
  
    public ResultSet getAllApplications()
    {
        return repo.getAllApplications();
    }

    public boolean updateStatus(int pid,String status)
    {
        return repo.updateStatus(pid,status);
    }
    public int getTotalCompanies()
    {
        return repo.getTotalCompanies();
    }

    public int getTotalStudents()
    {
        return repo.getTotalStudents();
    }

    public int getPlacedCount()
    {
        return repo.getPlacedCount();
    }

    public int getRejectedCount()
    {
        return repo.getRejectedCount();
    }
    
}
