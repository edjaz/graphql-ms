package fr.edjaz.blog.gateway.graphql.tag;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import org.springframework.stereotype.Component;

@Component
public class TagResolver implements GraphQLResolver<TagDTO> {

}
