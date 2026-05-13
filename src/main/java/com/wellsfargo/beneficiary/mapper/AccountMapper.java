package com.wellsfargo.beneficiary.mapper;
import com.wellsfargo.beneficiary.dto.AccountDTO;
import com.wellsfargo.beneficiary.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

 AccountDTO toDto(Account account);

 Account toEntity(AccountDTO accountDTO);

}