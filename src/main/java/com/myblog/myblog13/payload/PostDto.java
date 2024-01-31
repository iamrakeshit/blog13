package com.myblog.myblog13.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private long id;
    private String name;
    private String email;
    private String mobile;
}
