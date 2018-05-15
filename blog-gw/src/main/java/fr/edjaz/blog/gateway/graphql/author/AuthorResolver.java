package fr.edjaz.blog.gateway.graphql.author;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<AuthorDTO> {

}
