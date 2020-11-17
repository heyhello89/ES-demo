package com.okestro.elk.demo.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.okestro.elk.demo.dto.SpringTest;
import org.springframework.stereotype.Repository;

@Repository("SpringTest")
public interface SpringTestRepository extends ElasticsearchRepository<SpringTest, String> {
    SpringTest findByName(String name);
}
