package fr.edjaz.blog.gateway.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import fr.edjaz.blog.gateway.api.Author;
import fr.edjaz.blog.gateway.api.AuthorDTO;
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
