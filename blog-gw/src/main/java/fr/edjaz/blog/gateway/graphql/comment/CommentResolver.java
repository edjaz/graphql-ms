package fr.edjaz.blog.gateway.graphql.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<CommentDTO> {

    private final Author author;


    public CommentResolver(Author author) {
        this.author = author;
    }

    public AuthorDTO author(CommentDTO commentDTO){
        return author.getAuthor(commentDTO.getAuthorId());
    }
}
