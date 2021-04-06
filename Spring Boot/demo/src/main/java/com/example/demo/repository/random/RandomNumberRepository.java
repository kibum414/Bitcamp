package com.example.demo.repository.random;

import com.example.demo.entity.random.RandomNumber;
import org.springframework.stereotype.Repository;

@Repository
public class RandomNumberRepository {
    public RandomNumber getRandom() {
        return new RandomNumber();
    }
}
