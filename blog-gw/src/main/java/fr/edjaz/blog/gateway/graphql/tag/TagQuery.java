package fr.edjaz.blog.gateway.graphql.tag;

import java.util.List;

import fr.edjaz.blog.gateway.api.tag.Tag;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import fr.edjaz.blog.gateway.security.AuthoritiesConstants;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class TagQuery {
    private final Tag tag;

    public TagQuery(Tag tag) {
        this.tag = tag;
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public List<TagDTO> allTags() {
        return tag.getAllTags();
    }

    @Secured({AuthoritiesConstants.ADMIN, AuthoritiesConstants.USER})
    public TagDTO tag(String id){
        return tag.getTag(id);
    }
}
