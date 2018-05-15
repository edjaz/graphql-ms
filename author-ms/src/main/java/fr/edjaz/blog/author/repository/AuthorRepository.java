package fr.edjaz.blog.author.repository;

import java.util.Arrays;
import java.util.List;

import fr.edjaz.blog.author.domain.Author;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Author entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByNameLike(String nameQuery);
}
