package fr.edjaz.blog.gateway.api.post;

import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.api.common.Page;
import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(value = "/api/author/{id}/posts/page", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Page<PostDTO> getAllPostsByAuthorPage(@PathVariable("id") String id, @RequestParam("page") Integer page, @RequestParam("size") Integer size, @RequestParam("sort") Sort sort);

}
