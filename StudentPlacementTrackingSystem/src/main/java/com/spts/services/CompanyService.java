package com.spts.services;

import com.spts.model.Company;
import com.spts.repository.CompanyRepository;
import java.util.*;
public class CompanyService implements CompanyServiceInterface {

    CompanyRepository repository = new CompanyRepository();

    public boolean addCompany(Company company) {

        return repository.addCompany(company);
    }
    
    public List<Company> getAllCompanies()
    {
        return repository.getAllCompanies();
    }
    
    
    public Company getCompanyById(int cid)
    {
        return repository.getCompanyById(cid);
    }
    
    public boolean updateCompany(Company company)
    {
    	return repository.updateCompany(company);
    }
    
    public boolean deleteCompany(int cid)
    {
        return repository.deleteCompany(cid);
    }
    
}