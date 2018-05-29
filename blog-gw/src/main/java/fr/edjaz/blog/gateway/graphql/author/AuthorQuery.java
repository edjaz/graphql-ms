package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class AuthorQuery {
    private final Author author;

    public AuthorQuery(Author author) {
        this.author = author;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<AuthorDTO> allAuthors() {
        return author.getAllAuthors();
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<AuthorDTO> findAuthorsByName(String nameQuery) {
        return author.findByName(nameQuery);
    }
}
