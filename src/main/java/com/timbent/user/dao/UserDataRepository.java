package com.timbent.user.dao;

import com.timbent.user.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserDto, Long> {
    // @Query(value = "SELECT hl.data FROM hebrew_lexicon hl WHERE hl.data->>'StrNo' = :strongsNum", nativeQuery = true)

    @Query(value = "SELECT h1.data FROM user h1 WHERE h1.data->>'UserId' = ?1", nativeQuery = true)
    Optional<String> getUserData(String userId);

}
