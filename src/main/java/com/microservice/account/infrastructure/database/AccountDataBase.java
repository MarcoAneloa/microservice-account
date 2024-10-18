package com.microservice.account.infrastructure.database;

import com.microservice.account.domain.model.Account;
import com.microservice.account.domain.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDataBase implements AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query(
                "select * from account",
                (rs, rowNum) ->
                        new Account(
                                rs.getInt("id"),
                                rs.getString("number"),
                                rs.getString("type"),
                                rs.getDouble("Balance"),
                                rs.getBoolean("state"),
                                rs.getInt("customerId")
                        )
        );
    }

    @Override
    public int save(Account account) {
        return jdbcTemplate.update(
                "insert into account (number,type,balance,customerId,state) values (?,?,?,?,?)",
                account.getNumber(), account.getType(), account.getBalance(), account.getCustomerId(), account.getState());
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update(
                "update account set number = ?, type=?, balance=?, customerId=?, state=? where id = ?",
                account.getNumber(), account.getType(), account.getBalance(), account.getCustomerId(), account.getState(), account.getId());
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update(
                "delete from account where id = ?",
                id);
    }
}
