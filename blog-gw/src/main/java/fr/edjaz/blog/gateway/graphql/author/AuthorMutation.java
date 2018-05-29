package fr.edjaz.blog.gateway.graphql.author;


import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation {
    private final Author author;

    public AuthorMutation(Author author) {
        this.author = author;
    }


    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public AuthorDTO addAuthor(String name) {
        return author.createAuthor(new AuthorDTO(name));
    }

    public AuthorDTO removeAuthor(String id) {
        AuthorDTO auth = author.getAuthor(id);
        author.deleteAuthor(id);
        return auth;
    }

}
