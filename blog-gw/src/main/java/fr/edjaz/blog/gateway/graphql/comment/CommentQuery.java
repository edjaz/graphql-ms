package fr.edjaz.blog.gateway.graphql.comment;

import java.util.List;

import fr.edjaz.blog.gateway.api.comment.Comment;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class CommentQuery {
    private final Comment comment;

    public CommentQuery(Comment comment) {
        this.comment = comment;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<CommentDTO> allComments() {
        return comment.getAllComments();
    }
}
