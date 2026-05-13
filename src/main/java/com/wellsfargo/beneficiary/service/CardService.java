package com.wellsfargo.beneficiary.service;

import com.wellsfargo.beneficiary.dao.CardRepository;
import com.wellsfargo.beneficiary.entity.Card;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public Card createCard(Card card) {
        log.debug("Creating card: {}", card.getCardNumber());
        return cardRepository.save(card);
    }

    public List<Card> getCardsByBankerId(Long cardId) {
        log.debug("Fetching cards for banker: {}", cardId);
        return cardRepository.findByCardId(cardId);
    }

    public Card getCardById(Long cardId) {
        log.debug("Fetching card by id: {}", cardId);
        return cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found with id: " + cardId));
    }

    public Card updateCard(Card card) {
        log.debug("Updating card: {}", card.getCardId());
        return cardRepository.save(card);
    }

    public void deleteCard(Long cardId) {
        log.debug("Deleting card: {}", cardId);
        cardRepository.deleteById(cardId);
    }
}