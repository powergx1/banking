package com.jaqg.banking.mapper;

import com.jaqg.banking.dto.TransactionResponse;
import com.jaqg.banking.entities.Transaction;

import java.util.List;

public class TransactionsMapper {

    //Convert List of Transaction Entity to List of TransactionResponseDTO
    public static List<TransactionResponse> transactionListMapper(List<Transaction> transactions) {
        return transactions.stream()
                .map(TransactionsMapper::transactionMapper
                )
                .toList(); //collect to a list
    }

    public static TransactionResponse transactionMapper(Transaction transaction) {
        return new com.jaqg.banking.dto.TransactionResponse(
                transaction.getDateTime(),
                transaction.getTransType(),
                transaction.getSender() == null ? null : transaction.getSender().getNumber(),
                transaction.getSender() == null ? null : transaction.getSender().getSortCode(),
                transaction.getRecipient().getNumber(),
                transaction.getRecipient().getSortCode(),
                transaction.getTransVal());

    }
}
