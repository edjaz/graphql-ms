package fr.edjaz.blog.gateway.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import fr.edjaz.blog.gateway.api.Author;
import fr.edjaz.blog.gateway.api.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    private final Author author;

    public Mutation(Author author) {
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
