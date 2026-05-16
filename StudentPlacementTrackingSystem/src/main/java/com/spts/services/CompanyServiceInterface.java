package com.spts.services;


import java.util.List;

import com.spts.model.Company;

public interface CompanyServiceInterface {

    public boolean addCompany(Company company);
    public List<Company> getAllCompanies();
    public Company getCompanyById(int cid);
    public boolean updateCompany(Company company);
    public boolean deleteCompany(int cid);
    
}
