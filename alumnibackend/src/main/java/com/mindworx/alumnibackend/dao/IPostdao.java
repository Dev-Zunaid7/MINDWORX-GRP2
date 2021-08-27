package com.mindworx.alumnibackend.dao;

import java.util.List;

import com.mindworx.alumnibackend.model.PostContent;
import com.mindworx.alumnibackend.model.users.Mindworxuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface IPostdao extends JpaRepository<PostContent,Long> {

  List<PostContent> findPostByUserOrderById(Mindworxuser mindworxuser);

    List<PostContent> findAllByOrderByIdDesc();
}
