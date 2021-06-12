package com.totonero.analysisservice.repository;

import com.totonero.analysisservice.repository.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
