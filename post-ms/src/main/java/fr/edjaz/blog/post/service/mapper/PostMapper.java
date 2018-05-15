package fr.edjaz.blog.post.service.mapper;

import fr.edjaz.blog.post.domain.*;
import fr.edjaz.blog.post.service.dto.PostDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Post and its DTO PostDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PostMapper extends EntityMapper<PostDTO, Post> {


}
