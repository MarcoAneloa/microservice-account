package com.microservice.transaction.infrastructure.database;

import com.microservice.transaction.domain.model.Transaction;
import com.microservice.transaction.domain.model.dto.TransactionDTO;
import com.microservice.transaction.domain.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDataBase implements TransactionRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TransactionDTO> findAll() {
        return jdbcTemplate.query(
                "select t.id, t.date, c.name, a.number, a.type, t.initial_balance, a.state, t.value, t.final_balance from transaction t join customer c on t.customerId=c.id join account a on t.accountId=a.id",
                (rs, rowNum) ->
                        new TransactionDTO(
                                rs.getInt("id"),
                                rs.getString("date"),
                                rs.getString("name"),
                                rs.getString("number"),
                                rs.getString("type"),
                                rs.getBoolean("state"),
                                rs.getDouble("initial_balance"),
                                rs.getDouble("final_balance"),
                                rs.getDouble("value")
                        )
        );
    }

    @Override
    public int save(Transaction transaction) {
        return 0;
    }

    @Override
    public int update(Transaction transaction) {
        return 0;
    }

    @Override
    public int deleteById(Long id) {
        return 0;
    }

}
