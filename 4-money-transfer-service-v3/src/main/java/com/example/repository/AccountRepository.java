package com.example.repository;

import com.example.entity.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("jpa")
public interface AccountRepository extends JpaRepository<Account,String> {
}
