package fr.edjaz.blog.gateway.graphql;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import fr.edjaz.blog.gateway.api.author.AuthorDTO;
import fr.edjaz.blog.gateway.graphql.author.AuthorMutation;
import fr.edjaz.blog.gateway.graphql.comment.CommentMutation;
import fr.edjaz.blog.gateway.graphql.post.PostMutation;
import fr.edjaz.blog.gateway.graphql.tag.TagMutation;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {

    public AuthorDTO addAuthor(String name) {
        return authorQuery.addAuthor(name);
    }

    public AuthorDTO removeAuthor(String id) {
        return authorQuery.removeAuthor(id);
    }

    private final AuthorMutation authorQuery;
    private final CommentMutation commentQuery;
    private final TagMutation tagQuery;
    private final PostMutation postQuery;

    public Mutation(AuthorMutation authorQuery, CommentMutation commentQuery, TagMutation tagQuery, PostMutation postQuery) {
        this.authorQuery = authorQuery;
        this.commentQuery = commentQuery;
        this.tagQuery = tagQuery;
        this.postQuery = postQuery;
    }


}
