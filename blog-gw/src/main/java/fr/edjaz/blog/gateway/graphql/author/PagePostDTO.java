package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import fr.edjaz.blog.gateway.api.common.Page;
import fr.edjaz.blog.gateway.api.post.PostDTO;

public class PagePostDTO {

    private final List<PostDTO> content;
    private final Integer totalPages;
    private final Long totalElements;

    public PagePostDTO(List<PostDTO> content, Integer totalPages, Long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }


    public static PagePostDTO instance(Page<PostDTO> page) {
        return new PagePostDTO(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }

    public List<PostDTO> getContent() {
        return content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
