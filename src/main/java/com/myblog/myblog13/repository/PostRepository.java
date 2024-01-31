package com.myblog.myblog13.repository;

import com.myblog.myblog13.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
