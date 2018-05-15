package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import fr.edjaz.blog.gateway.api.author.Author;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final Author author;

    public Query(Author author) {
        this.author = author;
    }


    public List<AuthorDTO> allAuthors(){
        return author.getAllAuthors();
    }

    public List<AuthorDTO> findAuthorsByName(String nameQuery) {
        return author.findByName(nameQuery);
    }
}
