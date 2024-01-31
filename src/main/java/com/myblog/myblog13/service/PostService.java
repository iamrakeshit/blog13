package com.myblog.myblog13.service;

import com.myblog.myblog13.entity.Post;
import com.myblog.myblog13.payload.PostDto;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    PostDto createRegistration(PostDto postDto);

    PostDto getRegistrationById(long id);
}
