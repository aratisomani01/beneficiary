package com.wellsfargo.beneficiary.mapper;
import com.wellsfargo.beneficiary.dto.AccountDTO;
import com.wellsfargo.beneficiary.dto.CardDTO;
import com.wellsfargo.beneficiary.entity.Account;
import com.wellsfargo.beneficiary.entity.Card;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardMapper {

    CardDTO toDto(Card card);

    Card toEntity(CardDTO cardDTO);

}