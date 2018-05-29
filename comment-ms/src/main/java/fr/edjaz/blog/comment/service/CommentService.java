package fr.edjaz.blog.comment.service;

import fr.edjaz.blog.comment.service.dto.CommentDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Service Interface for managing Comment.
 */
public interface CommentService {

    /**
     * Save a comment.
     *
     * @param commentDTO the entity to save
     * @return the persisted entity
     */
    CommentDTO save(CommentDTO commentDTO);

    /**
     * Get all the comments.
     *
     * @return the list of entities
     */
    List<CommentDTO> findAll();

    /**
     * Get the "id" comment.
     *
     * @param id the id of the entity
     * @return the entity
     */
    CommentDTO findOne(String id);

    /**
     * Delete the "id" comment.
     *
     * @param id the id of the entity
     */
    void delete(String id);

    List<CommentDTO> getAllCommentsByPost(String id);

    Page<CommentDTO> getAllCommentsByPostPage(String id, Pageable pageable);

}
