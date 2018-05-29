package fr.edjaz.blog.gateway.graphql.post;

import java.util.List;

import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import fr.edjaz.blog.gateway.api.common.Page;

public class PageCommentDTO {

    private final List<CommentDTO> content;
    private final Integer totalPages;
    private final Long totalElements;

    public PageCommentDTO(List<CommentDTO> content, Integer totalPages, Long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }


    public static PageCommentDTO instance(Page<CommentDTO> page) {
        return new PageCommentDTO(page.getContent(),page.getTotalPages(),page.getTotalElements());
    }

    public List<CommentDTO> getContent() {
        return content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
