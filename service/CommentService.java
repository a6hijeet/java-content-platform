package service;

import java.util.List;

import model.Comment;
import model.dto.CommentDto;
import model.dto.UserDto;
import repository.impl.CommentRepository;

public class CommentService {
    CommentRepository commentRepo = new CommentRepository();
    public List<Comment> getAll() {
        return commentRepo.getAll();
    }
}
