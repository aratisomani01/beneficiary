package com.wellsfargo.beneficiary.controller;

import com.wellsfargo.beneficiary.dto.BeneficiaryDTO;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BeneficiaryController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloBeneficiary() {
       return ResponseEntity.ok("Welcome to Beneficiary Project");
    }

    @PostMapping("/beneficiary/create")
    public String addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO) {
        return "Beneficiary added successfully!";
    }

    @GetMapping("/beneficiary/fetch/{id}")
    public BeneficiaryDTO getBeneficiary(@PathVariable String id) {
        System.out.println("Beneficiary updated successfully!");
        return new BeneficiaryDTO();
    }

    @PutMapping("/beneficiary/update/{id}")
    public String updateBeneficiary(@PathVariable String id, @RequestBody BeneficiaryDTO beneficiaryDTO) {
        return "Beneficiary updated successfully!";
    }

    @DeleteMapping("/beneficiary/delete/{id}")
    public String deleteBeneficiary(@PathVariable String id) {
        return "Beneficiary deleted successfully!";
    }

}
