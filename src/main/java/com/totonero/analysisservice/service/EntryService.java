package com.totonero.analysisservice.service;

import java.util.List;
import java.util.Optional;

import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.repository.EntryRepository;
import com.totonero.analysisservice.repository.entity.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository repository;

    public void save(final Entry entry) {
        repository.save(entry);
    }

    public Optional<Entry> findByFixtureIdAndBetAndPeriod(final Long fixtureId, final BetType betType, final Period period) {
        return repository.findByFixtureIdAndBetAndPeriod(fixtureId, betType.name(), period);
    }
}
