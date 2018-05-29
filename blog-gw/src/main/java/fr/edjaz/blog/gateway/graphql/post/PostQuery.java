package fr.edjaz.blog.gateway.graphql.post;

import java.util.List;

import fr.edjaz.blog.gateway.api.post.Post;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class PostQuery {
    private final Post post;

    public PostQuery(Post post) {
        this.post = post;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<PostDTO> allPosts() {
        return post.getAllPosts();
    }
}
