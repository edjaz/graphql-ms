package fr.edjaz.blog.gateway.graphql.comment;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentResolver implements GraphQLResolver<CommentDTO> {

}
