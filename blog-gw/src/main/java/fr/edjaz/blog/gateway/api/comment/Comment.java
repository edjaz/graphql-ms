package fr.edjaz.blog.gateway.api.comment;

import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.api.common.Page;
import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@AuthorizedUserFeignClient(name = "comment")
public interface Comment {

    @RequestMapping(value = "/api/comments", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CommentDTO createComment(@Valid @RequestBody CommentDTO commentDTO);

    @RequestMapping(value = "/api/comments", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CommentDTO updateComment(@Valid @RequestBody CommentDTO commentDTO);

    @RequestMapping(value = "/api/comments", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CommentDTO> getAllComments();

    @RequestMapping(value = "/api/comments/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CommentDTO getComment(@PathVariable("id") String id);

    @RequestMapping(value = "/api/comments/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deleteComment(@PathVariable("id") String id);


    @RequestMapping(value = "/api/posts/{id}/comments", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<CommentDTO> getAllCommentsByPost(@PathVariable("id") String id);

    @RequestMapping(value = "/api/posts/{id}/comments/page", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Page<CommentDTO> getAllCommentsByPostPage(@PathVariable("id") String id, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sort") Sort sort);

}
