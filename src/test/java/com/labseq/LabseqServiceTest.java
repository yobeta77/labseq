package com.labseq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class LabseqServiceTest {

    @Autowired
    private LabseqService labseqService;

    @Test
    void getLabseqValue_withValidInput_shouldReturnCorrectValue() {
        assertEquals(0, labseqService.getLabseqValue(0));
        assertEquals(1, labseqService.getLabseqValue(1));
        assertEquals(0, labseqService.getLabseqValue(2));
        assertEquals(1, labseqService.getLabseqValue(3));
        assertEquals(1, labseqService.getLabseqValue(4));
        assertEquals(1, labseqService.getLabseqValue(5));
        assertEquals(1, labseqService.getLabseqValue(6));
        assertEquals(2, labseqService.getLabseqValue(7));
        assertEquals(2, labseqService.getLabseqValue(8));
        assertEquals(2, labseqService.getLabseqValue(9));
        assertEquals(3, labseqService.getLabseqValue(10));
        assertEquals(21, labseqService.getLabseqValue(20));
    }

    @Test
    void getLabseqValue_withNegativeInput_shouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> labseqService.getLabseqValue(-1));
    }
}
