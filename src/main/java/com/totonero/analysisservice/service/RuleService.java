package com.totonero.analysisservice.service;

import java.util.List;
import java.util.stream.Collectors;

import com.totonero.analysisservice.domain.RuleDTO;
import com.totonero.analysisservice.enums.BetType;
import com.totonero.analysisservice.enums.Period;
import com.totonero.analysisservice.enums.Rules;
import com.totonero.analysisservice.exceptions.ResourceNotFoundException;
import com.totonero.analysisservice.repository.RuleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RuleService {

    private final RuleRepository repository;
    private final ModelMapper modelMapper;

    public RuleDTO findByNameAndBetTypeAndPeriod(final Rules name, final BetType betType, final Period period) {
        return repository.findByNameAndBetAndPeriod(name, betType, period)
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .orElseThrow(ResourceNotFoundException::new);
    }

    public List<RuleDTO> findAnalysableRulesByBetAndPeriod(final BetType betType, final Period period) {
        return repository.findAnalysableRulesByBetAndPeriod(betType, period)
                .stream()
                .map(rule -> modelMapper.map(rule, RuleDTO.class))
                .collect(Collectors.toList());
    }
}
