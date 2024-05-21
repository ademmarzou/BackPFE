package com.pfe.HRS.Repository;


import com.pfe.HRS.Service.TokenS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<TokenS,Integer> {

    Optional<TokenS> findByToken(String token);
    Optional<TokenS> findByUserId(Long userId);




}