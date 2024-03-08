package com.zehraarslan.homework2.controllers;

import com.zehraarslan.homework2.dto.CompanyDto;
import com.zehraarslan.homework2.dto.CustomerDto;
import com.zehraarslan.homework2.request.CompanySaveRequest;
import com.zehraarslan.homework2.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyDto saveCompnay(@RequestBody CompanySaveRequest request) {
        return companyService.save(request);
    }

    @GetMapping
    public List<CompanyDto> getAllCompany() {
        return companyService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        companyService.delete(id);
    }
}
