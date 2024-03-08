package com.zehraarslan.homework2.mapper;

import com.zehraarslan.homework2.dto.CompanyDto;
import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.entity.Company;
import com.zehraarslan.homework2.request.CompanySaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company convertToCompany(CompanySaveRequest request);
    CompanyDto convertToCompanyDto(Company company);
    List<CompanyDto> convertToCompanyDtos(List<Company> companies);
    List<Company> convertToCompanies(List<CompanySaveRequest> companySaveRequests);
}
