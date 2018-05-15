package fr.edjaz.blog.gateway.graphql.post;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<PostDTO> {

}
