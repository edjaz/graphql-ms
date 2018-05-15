package fr.edjaz.blog.author.service.mapper;

import fr.edjaz.blog.author.domain.*;
import fr.edjaz.blog.author.service.dto.AuthorDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Author and its DTO AuthorDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AuthorMapper extends EntityMapper<AuthorDTO, Author> {


}
