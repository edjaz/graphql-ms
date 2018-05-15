package fr.edjaz.blog.comment.service.mapper;

import fr.edjaz.blog.comment.domain.*;
import fr.edjaz.blog.comment.service.dto.CommentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Comment and its DTO CommentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {


}
