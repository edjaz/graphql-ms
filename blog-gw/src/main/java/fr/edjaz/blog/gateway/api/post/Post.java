package fr.edjaz.blog.gateway.api.post;

import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@AuthorizedUserFeignClient(name = "post")
public interface Post {

    @RequestMapping(value = "/api/posts", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PostDTO createPost(@Valid @RequestBody PostDTO postDTO);

    @RequestMapping(value = "/api/posts", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PostDTO updatePost(@Valid @RequestBody PostDTO postDTO);

    @RequestMapping(value = "/api/posts", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getAllPosts();

    @RequestMapping(value = "/api/posts/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    PostDTO getPost(@PathVariable("id") String id);

    @RequestMapping(value = "/api/posts/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deletePost(@PathVariable("id") String id);

    @RequestMapping(value = "/api/author/{id}/posts", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<PostDTO> getAllPostsByAuthor(@PathVariable("id") String id);
}
