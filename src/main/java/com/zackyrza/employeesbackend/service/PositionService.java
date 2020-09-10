package com.zackyrza.employeesbackend.service;

import com.zackyrza.employeesbackend.model.Position;
import com.zackyrza.employeesbackend.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public Optional<Position> findById(Long id) {
        return positionRepository.findById(id);
    }

    public Optional<Position> deleteById(Long id) {
        positionRepository.deleteById(id);
        return Optional.empty();
    }

    public Position save(Position position) {
        return positionRepository.save(position);
    }
}
