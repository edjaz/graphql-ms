package fr.edjaz.blog.gateway.api.tag;

import java.util.List;
import javax.validation.Valid;

import fr.edjaz.blog.gateway.client.AuthorizedUserFeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@AuthorizedUserFeignClient(name = "tag")
interface TagClient {
    @RequestMapping(value = "/tags", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO createTag(@Valid @RequestBody TagDTO tagDTO);

    @RequestMapping(value = "/tags", method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO updateTag(@Valid @RequestBody TagDTO tagDTO);

    @RequestMapping(value = "/tags", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    List<TagDTO> getAllTags();

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    TagDTO getTag(@PathVariable("id") Long id);

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    Void deleteTag(@PathVariable("id") Long id);


}
