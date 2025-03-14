package com.eazybytes.accounts.mapper;

import com.eazybytes.accounts.dto.AccountsDto;
import com.eazybytes.accounts.entity.Accounts;

import java.math.BigDecimal;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts) {
        if (accounts == null) {
            return null;
        }

        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBalance(BigDecimal.valueOf(accounts.getBalance()));
        accountsDto.setIfscCode(accounts.getIfscCode());

        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto) {
        if (accountsDto == null) {
            return null;
        }

        Accounts accounts = new Accounts();
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBalance(accountsDto.getBalance().doubleValue());
        accounts.setIfscCode(accountsDto.getIfscCode());

        return accounts;
    }
}
