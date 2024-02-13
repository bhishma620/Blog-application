package com.bhishma.app.payloads;

import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    private List<PostDto> content;
    private int pageNumber;
    private int pageSize;
    private long totalElments;
    private int totalPages;
    private boolean lastPage;

}
