package fr.edjaz.blog.gateway.graphql.author;


import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorMutation {
    private final Author author;

    public AuthorMutation(Author author) {
        this.author = author;
    }

    public AuthorDTO addAuthor(String name) {
        return author.createAuthor(new AuthorDTO(name));
    }

    public AuthorDTO removeAuthor(String id) {
        AuthorDTO auth = author.getAuthor(id);
        author.deleteAuthor(id);
        return auth;
    }

}
