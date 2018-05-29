package fr.edjaz.blog.gateway.api.tag;

import java.util.List;
import javax.validation.Valid;
import javax.ws.rs.Path;

import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@AuthorizedUserFeignClient(name = "tag")
public interface Tag {
    @RequestMapping(value = "/api/tags", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO createTag(@Valid @RequestBody TagDTO tagDTO);

    @RequestMapping(value = "/api/tags", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO updateTag(@Valid @RequestBody TagDTO tagDTO);

    @RequestMapping(value = "/api/tags", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<TagDTO> getAllTags();

    @RequestMapping(value = "/api/tags/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO getTag(@PathVariable("id") String id);

    @RequestMapping(value = "/api/tags/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deleteTag(@PathVariable("id") String id);


}
