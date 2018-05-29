package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.post.Post;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<AuthorDTO> {
    private final Post post;

    public AuthorResolver(Post post) {
        this.post = post;
    }

    public List<PostDTO> posts(AuthorDTO authorDTO) {
        return post.getAllPostsByAuthor(authorDTO.getId());
    }

    public PagePostDTO postsPage(AuthorDTO authorDTO, Integer page, Integer size, Sort.Direction direction, String field) {
        return PagePostDTO.instance(post.getAllPostsByAuthorPage(authorDTO.getId(), page, size, new Sort(direction,field)));
    }
}
