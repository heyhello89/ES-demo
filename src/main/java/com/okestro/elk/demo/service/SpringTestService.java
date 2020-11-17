package com.okestro.elk.demo.service;

import com.google.common.collect.Lists;
import com.okestro.elk.demo.repository.SpringTestRepository;
import com.okestro.elk.demo.dto.SpringTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringTestService {

    @Autowired
    private SpringTestRepository springTestRepository;

    public List<SpringTest> findAll() {
        return Lists.newArrayList(springTestRepository.findAll());
    }

    public void save(SpringTest springTest) {
        springTestRepository.save(springTest);
    }

    public SpringTest findByUsername(String name) {
        return springTestRepository.findByName(name);
    }
}
