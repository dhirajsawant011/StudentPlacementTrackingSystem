package com.spts.repository;

import java.util.List;

import com.spts.model.Company;

public interface CompanyRepositoryInterface {

    public boolean addCompany(Company company);
    public List<Company> getAllCompanies();
    public Company getCompanyById(int cid);
    public boolean updateCompany(Company company);
    public boolean deleteCompany(int cid);
    
}