package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.post.Post;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<AuthorDTO> {
    private final Post post;

    public AuthorResolver(Post post) {
        this.post = post;
    }

    public List<PostDTO> posts(AuthorDTO authorDTO){
        return post.getAllPostsByAuthor(authorDTO.getId());
    }
}
