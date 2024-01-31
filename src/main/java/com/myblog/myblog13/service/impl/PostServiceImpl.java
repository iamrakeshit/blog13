package com.myblog.myblog13.service.impl;

import com.myblog.myblog13.entity.Post;
import com.myblog.myblog13.exception.ResourceNotFoundException;
import com.myblog.myblog13.payload.PostDto;
import com.myblog.myblog13.repository.PostRepository;
import com.myblog.myblog13.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public PostDto createRegistration(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post spost = repository.save(post);
        PostDto dto1 = mapToDto(spost);
        return dto1;
    }

    @Override
    public PostDto getRegistrationById(long id) {
        Post post =repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Registration is not found with id "+id)
        );
        PostDto dto = mapToDto(post);
        return dto;
    }

    @Override
    public List<PostDto> getAllRegistration(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        Page<Post> pageposts = repository.findAll(pageable);
        List<Post> posts = pageposts.getContent();
        List<PostDto> dto = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dto;
    }


    Post mapToEntity(PostDto Dto){
        Post post = new Post();
        post.setName(Dto.getName());
        post.setEmail(Dto.getEmail());
        post.setMobile(Dto.getMobile());
        return post;
    }
    PostDto mapToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setName(post.getName());
        dto.setEmail(post.getEmail());
        dto.setMobile(post.getMobile());
        return dto;
    }
}
