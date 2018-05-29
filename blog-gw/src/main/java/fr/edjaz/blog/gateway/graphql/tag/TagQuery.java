package fr.edjaz.blog.gateway.graphql.tag;

import java.util.List;

import fr.edjaz.blog.gateway.api.tag.Tag;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import org.springframework.stereotype.Component;

@Component
public class TagQuery {
    private final Tag tag;

    public TagQuery(Tag tag) {
        this.tag = tag;
    }

    public List<TagDTO> allTags() {
        return tag.getAllTags();
    }

    public TagDTO tag(String id){
        return tag.getTag(id);
    }
}
