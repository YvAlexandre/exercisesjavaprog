package be.ing.repository;

import be.ing.exception.CompanyNotFoundException;
import be.ing.service.Company;

public interface CompanyRepository {
    Company findCompany(int id) throws CompanyNotFoundException;
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company c) throws CompanyNotFoundException;
    void updateCompany(Company c) throws CompanyNotFoundException;
    void deleteCompany(int id) throws CompanyNotFoundException;
}
