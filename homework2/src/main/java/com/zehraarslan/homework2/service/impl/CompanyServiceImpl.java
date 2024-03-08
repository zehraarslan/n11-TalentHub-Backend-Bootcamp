package com.zehraarslan.homework2.service.impl;

import com.zehraarslan.homework2.dto.CompanyDto;
import com.zehraarslan.homework2.entity.Company;
import com.zehraarslan.homework2.entity.Customer;
import com.zehraarslan.homework2.mapper.CompanyMapper;
import com.zehraarslan.homework2.mapper.CustomerMapper;
import com.zehraarslan.homework2.repository.CompanyRepository;
import com.zehraarslan.homework2.request.CompanySaveRequest;
import com.zehraarslan.homework2.request.CustomerSaveRequest;
import com.zehraarslan.homework2.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDto save(CompanySaveRequest request) {
        Company company = CompanyMapper.INSTANCE.convertToCompany(request);
        company = companyRepository.save(company);
        CompanyDto companyDto = CompanyMapper.INSTANCE.convertToCompanyDto(company);
        return companyDto;
    }

    @Override
    public List<CompanyDto> saveAll(List<CompanySaveRequest> requests) {
        List<Company> companies = CompanyMapper.INSTANCE.convertToCompanies(requests);
        companies = companyRepository.saveAll(companies);
        List<CompanyDto> companyDtos = CompanyMapper.INSTANCE.convertToCompanyDtos(companies);
        return companyDtos;
    }

    @Override
    public List<CompanyDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        List<CompanyDto> companyDtos = CompanyMapper.INSTANCE.convertToCompanyDtos(companies);
        return companyDtos;
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            companyRepository.delete(company);
        }
    }

    @Override
    public String getCompanyNameById(Long companyId) {

        return companyRepository.findCompanyNameById(companyId);
    }
}
