package com.example.board.service.random;

import com.example.board.entity.random.RandomNumber;
import com.example.board.repository.random.RandomNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RandomNumberServiceImpl implements RandomNumberService {

    // repository는 단순 db 연산용이 아님

    @Autowired
    private RandomNumberRepository randNumRepo;

    @Override
    public RandomNumber getRandom() {
        return randNumRepo.getRandom();
    }
}
