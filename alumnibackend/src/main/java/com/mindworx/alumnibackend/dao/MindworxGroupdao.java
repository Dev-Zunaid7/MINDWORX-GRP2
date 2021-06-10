package com.mindworx.alumnibackend.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mindworx.alumnibackend.model.users.MindworxGroup;

import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
@Transactional(readOnly = true)
public interface MindworxGroupdao extends PagingAndSortingRepository<MindworxGroup, Long>{
    MindworxGroup findByCode(String code);
}
