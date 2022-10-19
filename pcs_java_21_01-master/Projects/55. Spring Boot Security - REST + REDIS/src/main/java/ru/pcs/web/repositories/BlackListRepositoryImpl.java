package ru.pcs.web.repositories;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * 26.11.2021
 * 55. Spring Boot Security - REST + REDIS
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Repository
public class BlackListRepositoryImpl implements BlackListRepository {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void save(String token) {
        redisTemplate.opsForValue().set(token, "");
    }

    @Override
    public boolean exists(String token) {
        Boolean hasToken = redisTemplate.hasKey(token);
        return hasToken != null && hasToken;
    }
}
