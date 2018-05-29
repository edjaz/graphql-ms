package fr.edjaz.blog.gateway.graphql.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<CommentDTO> {

    private final Author author;


    public CommentResolver(Author author) {
        this.author = author;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public AuthorDTO author(CommentDTO commentDTO){
        return author.getAuthor(commentDTO.getAuthorId());
    }
}
