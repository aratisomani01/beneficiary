package com.wellsfargo.beneficiary.mapper;
import com.wellsfargo.beneficiary.dto.LoanDTO;
import com.wellsfargo.beneficiary.entity.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    LoanDTO toDto(Loan loan);

    Loan toEntity(LoanDTO loanDTO);

}