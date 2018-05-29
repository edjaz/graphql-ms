package fr.edjaz.blog.gateway.graphql.tag;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotNull;

import fr.edjaz.blog.gateway.api.tag.TagDTO;

/**
 * A DTO for the Tag entity.
 */
public class TagVM implements Serializable {

    private String id;
    @NotNull
    private String name;

    public static TagDTO toDTO(TagVM tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.id);
        tagDTO.setName(tag.name);
        return tagDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TagVM tagDTO = (TagVM) o;
        if (tagDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), tagDTO.getId());
    }
    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    @Override
    public String toString() {
        return "TagDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
