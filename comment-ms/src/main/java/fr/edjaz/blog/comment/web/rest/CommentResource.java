package fr.edjaz.blog.comment.web.rest;

import com.codahale.metrics.annotation.Timed;
import fr.edjaz.blog.comment.service.CommentService;
import fr.edjaz.blog.comment.web.rest.errors.BadRequestAlertException;
import fr.edjaz.blog.comment.web.rest.util.HeaderUtil;
import fr.edjaz.blog.comment.service.dto.CommentDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Comment.
 */
@RestController
@RequestMapping("/api")
public class CommentResource {

    private final Logger log = LoggerFactory.getLogger(CommentResource.class);

    private static final String ENTITY_NAME = "comment";

    private final CommentService commentService;

    public CommentResource(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * POST  /comments : Create a new comment.
     *
     * @param commentDTO the commentDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new commentDTO, or with status 400 (Bad Request) if the comment has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/comments")
    @Timed
    public ResponseEntity<CommentDTO> createComment(@Valid @RequestBody CommentDTO commentDTO) throws URISyntaxException {
        log.debug("REST request to save Comment : {}", commentDTO);
        if (commentDTO.getId() != null) {
            throw new BadRequestAlertException("A new comment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CommentDTO result = commentService.save(commentDTO);
        return ResponseEntity.created(new URI("/api/comments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /comments : Updates an existing comment.
     *
     * @param commentDTO the commentDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated commentDTO,
     * or with status 400 (Bad Request) if the commentDTO is not valid,
     * or with status 500 (Internal Server Error) if the commentDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/comments")
    @Timed
    public ResponseEntity<CommentDTO> updateComment(@Valid @RequestBody CommentDTO commentDTO) throws URISyntaxException {
        log.debug("REST request to update Comment : {}", commentDTO);
        if (commentDTO.getId() == null) {
            return createComment(commentDTO);
        }
        CommentDTO result = commentService.save(commentDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, commentDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /comments : get all the comments.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of comments in body
     */
    @GetMapping("/comments")
    @Timed
    public List<CommentDTO> getAllComments() {
        log.debug("REST request to get all Comments");
        return commentService.findAll();
        }

    /**
     * GET  /comments/:id : get the "id" comment.
     *
     * @param id the id of the commentDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the commentDTO, or with status 404 (Not Found)
     */
    @GetMapping("/comments/{id}")
    @Timed
    public ResponseEntity<CommentDTO> getComment(@PathVariable String id) {
        log.debug("REST request to get Comment : {}", id);
        CommentDTO commentDTO = commentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(commentDTO));
    }

    /**
     * DELETE  /comments/:id : delete the "id" comment.
     *
     * @param id the id of the commentDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/comments/{id}")
    @Timed
    public ResponseEntity<Void> deleteComment(@PathVariable String id) {
        log.debug("REST request to delete Comment : {}", id);
        commentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }


    @GetMapping("/posts/{id}/comments")
    public List<CommentDTO> getAllCommentsByPost(@PathVariable String id){
        return commentService.getAllCommentsByPost(id);
    }


    @GetMapping("/posts/{id}/comments/page")
    Page<CommentDTO> getAllCommentsByPostPage(@PathVariable("id") String id, Pageable pageable){
        return commentService.getAllCommentsByPostPage(id,pageable);
    }

}
