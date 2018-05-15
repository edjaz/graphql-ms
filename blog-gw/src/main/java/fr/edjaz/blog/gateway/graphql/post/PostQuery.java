package fr.edjaz.blog.gateway.graphql.post;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class PostQuery implements GraphQLQueryResolver {
    private final Author author;

    public PostQuery(Author author) {
        this.author = author;
    }


    public List<AuthorDTO> allAuthors(){
        return author.getAllAuthors();
    }

    public List<AuthorDTO> findAuthorsByName(String nameQuery) {
        return author.findByName(nameQuery);
    }
}
