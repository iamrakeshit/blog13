package com.myblog.myblog13.controller;

import com.myblog.myblog13.payload.PostDto;
import com.myblog.myblog13.repository.PostRepository;
import com.myblog.myblog13.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//      http://localhost:8080/rest/api
@RestController
@RequestMapping("/rest/api")
public class PostController {
    private PostService service;
    public PostController(PostService service) {
        this.service = service;
    }
@PostMapping
    public ResponseEntity<PostDto> createRegistration(@RequestBody PostDto postDto){
        PostDto createReg = service.createRegistration(postDto);
        return new ResponseEntity<>(createReg,HttpStatus.CREATED);
    }
    //      http://localhost:8080/rest/api/byId
    @GetMapping("/byId")
    public ResponseEntity<PostDto>getRegistrationById(@RequestParam long id){
        PostDto byId = service.getRegistrationById(id);
        return new ResponseEntity<>(byId,HttpStatus.OK);
    }
    //      http://localhost:8080/rest/api/getAll
    @GetMapping("/getAll")
    public List<PostDto> getAllRegistration(){
        List<PostDto> allRegistration = service.getAllRegistration();
        return allRegistration;
    }
}