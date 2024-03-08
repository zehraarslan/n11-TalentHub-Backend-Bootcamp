package com.zehraarslan.homework2.service;

import com.zehraarslan.homework2.dto.CompanyDto;
import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.entity.Company;
import com.zehraarslan.homework2.request.CompanySaveRequest;
import com.zehraarslan.homework2.request.CustomerSaveRequest;

import java.util.List;

public interface CompanyService {
    CompanyDto save(CompanySaveRequest request);
    List<CompanyDto> saveAll(List<CompanySaveRequest> requests);
    List<CompanyDto> getAll();
    void delete(Long id);
    String getCompanyNameById(Long companyId);
}
