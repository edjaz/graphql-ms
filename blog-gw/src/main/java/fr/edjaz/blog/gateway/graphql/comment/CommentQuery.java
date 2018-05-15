package fr.edjaz.blog.gateway.graphql.comment;

import java.util.List;

import fr.edjaz.blog.gateway.api.comment.Comment;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentQuery {
    private final Comment comment;

    public CommentQuery(Comment comment) {
        this.comment = comment;
    }

    public List<CommentDTO> allComments() {
        return comment.getAllComments();
    }
}
