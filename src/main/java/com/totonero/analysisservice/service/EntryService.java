package com.totonero.analysisservice.service;

import com.totonero.analysisservice.domain.EntryDTO;
import com.totonero.analysisservice.repository.EntryRepository;
import com.totonero.analysisservice.repository.entity.Entry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntryService {

    private final EntryRepository repository;
    private final ModelMapper modelMapper;

    public void save(final EntryDTO entry) {
        repository.save(modelMapper.map(entry, Entry.class));
    }

}
