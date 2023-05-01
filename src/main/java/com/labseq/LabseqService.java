package com.labseq;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
@EnableCaching
public class LabseqService {

    private final Map<Integer, Long> cache = new HashMap<>();
    @Cacheable(value = "labseq", key = "#n")
    public long getLabseqValue(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }
        if (n <= 3) {
            return Integer.valueOf((n == 0 || n == 2) ? 0 : 1);
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        long result = getLabseqValue(n-4) + getLabseqValue(n-3);
        cache.put(n, result);
        return result;
    }
}
