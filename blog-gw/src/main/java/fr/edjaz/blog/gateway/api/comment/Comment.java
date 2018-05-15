package fr.edjaz.blog.gateway.api.comment;

import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
    CommentDTO getComment(@PathVariable("id") Long id);

    @RequestMapping(value = "/api/comments/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deleteComment(@PathVariable("id") Long id);


}
