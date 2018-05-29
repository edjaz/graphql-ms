package fr.edjaz.blog.gateway.graphql.author;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.post.Post;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class AuthorResolver implements GraphQLResolver<AuthorDTO> {
    private final Post post;

    public AuthorResolver(Post post) {
        this.post = post;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<PostDTO> posts(AuthorDTO authorDTO) {
        return post.getAllPostsByAuthor(authorDTO.getId());
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public PagePostDTO postsPage(AuthorDTO authorDTO, Integer page, Integer size, Sort.Direction direction, String field) {
        return PagePostDTO.instance(post.getAllPostsByAuthorPage(authorDTO.getId(), page, size, new Sort(direction,field)));
    }
}
