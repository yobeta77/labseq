package com.labseq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;


@RestController
public class LabseqController {

    private final LabseqService service;

    @Autowired
    public LabseqController(LabseqService service ) {
        this.service = service;
    }

    @GetMapping("/labseq/{n}")
    public long getLabseqValue(@PathVariable int n) {
        return service.getLabseqValue(n);
    }
}
