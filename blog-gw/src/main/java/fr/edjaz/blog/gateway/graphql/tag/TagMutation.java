package fr.edjaz.blog.gateway.graphql.tag;


import fr.edjaz.blog.gateway.api.tag.Tag;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import org.springframework.stereotype.Component;

@Component
public class TagMutation {
    private final Tag tag;

    public TagMutation(Tag tag) {
        this.tag = tag;
    }

    public TagDTO saveTag(TagVM tag ){


        if(tag.getId() == null){
            return this.tag.createTag(TagVM.toDTO(tag));
        }else{
            return this.tag.updateTag(TagVM.toDTO(tag));
        }
    }
}
