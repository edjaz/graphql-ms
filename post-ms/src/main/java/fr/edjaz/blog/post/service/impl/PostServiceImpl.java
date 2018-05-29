package fr.edjaz.blog.post.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import fr.edjaz.blog.post.domain.Post;
import fr.edjaz.blog.post.repository.PostRepository;
import fr.edjaz.blog.post.service.PostService;
import fr.edjaz.blog.post.service.dto.PostDTO;
import fr.edjaz.blog.post.service.mapper.PostMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for managing Post.
 */
@Service
public class PostServiceImpl implements PostService {

    private final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    private final PostRepository postRepository;

    private final PostMapper postMapper;

    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    /**
     * Save a post.
     *
     * @param postDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PostDTO save(PostDTO postDTO) {
        log.debug("Request to save Post : {}", postDTO);
        Post post = postMapper.toEntity(postDTO);
        post = postRepository.save(post);
        return postMapper.toDto(post);
    }

    /**
     * Get all the posts.
     *
     * @return the list of entities
     */
    @Override
    public List<PostDTO> findAll() {
        log.debug("Request to get all Posts");
        return postRepository.findAll().stream()
            .map(postMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one post by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public PostDTO findOne(String id) {
        log.debug("Request to get Post : {}", id);
        Post post = postRepository.findOne(id);
        return postMapper.toDto(post);
    }

    /**
     * Delete the post by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Post : {}", id);
        postRepository.delete(id);
    }

    @Override
    public List<PostDTO> getAllPostsByAuthor(String id) {
        return postRepository.findAllByAuthorId(id)
            .stream()
            .map(postMapper::toDto)
            .collect(Collectors.toList());
    }

    @Override
    public Page<PostDTO> getAllPostsByAuthorPage(String id, Pageable pageable) {
        Page<Post> res = postRepository.findAllByAuthorId(id, pageable);
        List<PostDTO> content = res.getContent().stream().map(postMapper::toDto).collect(Collectors.toList());
        return new PageImpl(content, pageable, res.getTotalElements());
    }
}
