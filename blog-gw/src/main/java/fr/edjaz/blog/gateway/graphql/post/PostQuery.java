package fr.edjaz.blog.gateway.graphql.post;

import java.util.List;

import fr.edjaz.blog.gateway.api.post.Post;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class PostQuery {
    private final Post post;

    public PostQuery(Post post) {
        this.post = post;
    }

    public List<PostDTO> allPosts() {
        return post.getAllPosts();
    }
}
