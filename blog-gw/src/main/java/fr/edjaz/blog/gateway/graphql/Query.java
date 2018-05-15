package fr.edjaz.blog.gateway.graphql;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import fr.edjaz.blog.gateway.graphql.author.AuthorQuery;
import fr.edjaz.blog.gateway.graphql.comment.CommentQuery;
import fr.edjaz.blog.gateway.graphql.post.PostQuery;
import fr.edjaz.blog.gateway.graphql.tag.TagQuery;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {
    private final AuthorQuery authorQuery;
    private final CommentQuery commentQuery;
    private final TagQuery tagQuery;
    private final PostQuery postQuery;

    public Query(AuthorQuery authorQuery, CommentQuery commentQuery, TagQuery tagQuery, PostQuery postQuery) {
        this.authorQuery = authorQuery;
        this.commentQuery = commentQuery;
        this.tagQuery = tagQuery;
        this.postQuery = postQuery;
    }


    public List<PostDTO> allPosts() {
        return postQuery.allPosts();
    }

    public List<TagDTO> allTags() {
        return tagQuery.allTags();
    }


    public List<AuthorDTO> allAuthors() {
        return authorQuery.allAuthors();
    }

    public List<AuthorDTO> findAuthorsByName(String nameQuery) {
        return authorQuery.findAuthorsByName(nameQuery);
    }

    public List<CommentDTO> allComments() {
        return commentQuery.allComments();
    }
}
