package fr.edjaz.blog.post.repository;

import java.util.List;

import fr.edjaz.blog.post.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Post entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findAllByAuthorId(String id);

    Page<Post> findAllByAuthorId(String id, Pageable pageable);
}
