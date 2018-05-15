package fr.edjaz.blog.gateway.api;

import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.client.AuthorizedFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@AuthorizedFeignClient(name = "author")
public interface Author {
    @RequestMapping(value = "/api/authors", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorDTO createAuthor(@Valid @RequestBody AuthorDTO authorDTO);

    @RequestMapping(value = "/api/authors", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorDTO updateAuthor(@Valid @RequestBody AuthorDTO authorDTO);

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<AuthorDTO> getAllAuthors();

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    AuthorDTO getAuthor(@PathVariable("id") String id);

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deleteAuthor(@PathVariable("id") String id);


    @RequestMapping(value = "/api/authors/search", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<AuthorDTO> findByName(@RequestParam(name = "name") String nameQuery);
}
