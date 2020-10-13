package com.smals.services;

import com.smals.domain.Difficulty;
import com.smals.repositories.SPRINGDATA.DifficultyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DifficultyServiceImpl implements GenericCrudService<Difficulty> {

    private DifficultyRepository difficultyRepository;

    public DifficultyServiceImpl(DifficultyRepository difficultyRepository) {
        this.difficultyRepository = difficultyRepository;
    }

    @Override
    public List<Difficulty> findAll() {
        return difficultyRepository.findAll();
    }

    @Override
    public void save(Difficulty entity) {
    }

    @Override
    public void deleteById(int id) {
    }

    @Override
    public Difficulty findById(int id) {
        return difficultyRepository.findById(id).get();
    }
}
