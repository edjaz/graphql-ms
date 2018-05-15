package fr.edjaz.blog.tag.service.mapper;

import fr.edjaz.blog.tag.domain.*;
import fr.edjaz.blog.tag.service.dto.TagDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Tag and its DTO TagDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TagMapper extends EntityMapper<TagDTO, Tag> {


}
