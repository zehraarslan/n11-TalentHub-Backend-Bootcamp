package com.zehraarslan.homework2.repository;

import com.zehraarslan.homework2.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    String findCompanyNameById(Long id);
}
