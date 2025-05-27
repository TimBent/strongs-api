package com.timbent.strongsdataapi.url;

import com.timbent.strongsdataapi.StrongsData;
import com.timbent.strongsdataapi.StrongsEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StrongsDataRepository extends JpaRepository<StrongsData, Long> {
    // @Query(value = "SELECT hl.data FROM hebrew_lexicon hl WHERE hl.data->>'StrNo' = :strongsNum", nativeQuery = true)

    @Query(value = "SELECT h1.data FROM hebrew_lexicon_2 h1 WHERE h1.data->>'StrNo' = ?1", nativeQuery = true)
    Optional<String> findByStrongsNumber(String strongsNumber);

}
