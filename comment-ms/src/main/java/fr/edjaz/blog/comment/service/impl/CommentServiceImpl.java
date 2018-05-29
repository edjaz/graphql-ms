package fr.edjaz.blog.comment.service.impl;

import fr.edjaz.blog.comment.service.CommentService;
import fr.edjaz.blog.comment.domain.Comment;
import fr.edjaz.blog.comment.repository.CommentRepository;
import fr.edjaz.blog.comment.service.dto.CommentDTO;
import fr.edjaz.blog.comment.service.mapper.CommentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Comment.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    private final CommentRepository commentRepository;

    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }

    /**
     * Save a comment.
     *
     * @param commentDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CommentDTO save(CommentDTO commentDTO) {
        log.debug("Request to save Comment : {}", commentDTO);
        Comment comment = commentMapper.toEntity(commentDTO);
        comment = commentRepository.save(comment);
        return commentMapper.toDto(comment);
    }

    /**
     * Get all the comments.
     *
     * @return the list of entities
     */
    @Override
    public List<CommentDTO> findAll() {
        log.debug("Request to get all Comments");
        return commentRepository.findAll().stream()
            .map(commentMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one comment by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public CommentDTO findOne(String id) {
        log.debug("Request to get Comment : {}", id);
        Comment comment = commentRepository.findOne(id);
        return commentMapper.toDto(comment);
    }

    /**
     * Delete the comment by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Comment : {}", id);
        commentRepository.delete(id);
    }

    @Override
    public List<CommentDTO> getAllCommentsByPost(String id) {
        return commentRepository.findAllByPostId(id).stream()
            .map(commentMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    @Override
    public Page<CommentDTO> getAllCommentsByPostPage(String id, Pageable pageable) {
        Page<Comment> res = commentRepository.findAllByPostId(id, pageable);
        List<CommentDTO> content = res.getContent().stream().map(commentMapper::toDto).collect(Collectors.toList());
        return new PageImpl(content, pageable, res.getTotalElements());
    }


}
