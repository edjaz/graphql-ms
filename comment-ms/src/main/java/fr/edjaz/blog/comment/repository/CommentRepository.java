package fr.edjaz.blog.comment.repository;

import java.util.List;

import fr.edjaz.blog.comment.domain.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Comment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    List<Comment> findAllByPostId(String id);

    Page<Comment> findAllByPostId(String id, Pageable pageable);
}
