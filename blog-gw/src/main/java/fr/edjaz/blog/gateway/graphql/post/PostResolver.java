package fr.edjaz.blog.gateway.graphql.post;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import fr.edjaz.blog.gateway.api.comment.Comment;
import fr.edjaz.blog.gateway.api.comment.CommentDTO;
import fr.edjaz.blog.gateway.api.post.PostDTO;
import fr.edjaz.blog.gateway.api.tag.Tag;
import fr.edjaz.blog.gateway.api.tag.TagDTO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PostResolver implements GraphQLResolver<PostDTO> {
    private final Tag tag;
    private final Comment comment;

    public PostResolver(Tag tag, Comment comment) {
        this.tag = tag;
        this.comment = comment;
    }


    public TagDTO tag(PostDTO postDTO){
        return tag.getTag(postDTO.getTagId());
    }


    public List<CommentDTO> comments(PostDTO postDTO){
        return comment.getAllCommentsByPost(postDTO.getId());
    }

    public PageCommentDTO commentsPage(PostDTO postDTO,Integer page, Integer size, Sort.Direction direction, String field){
        Sort sort = new Sort(direction, field);
        return PageCommentDTO.instance(comment.getAllCommentsByPostPage(postDTO.getId(),page,size,sort));
    }
}


