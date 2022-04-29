package com.travelpoint.service.impl;

import com.travelpoint.model.entity.CommentEntity;
import com.travelpoint.model.service.CommentAddServiceModel;
import com.travelpoint.model.view.CommentViewModel;
import com.travelpoint.repository.CommentRepository;
import com.travelpoint.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void add(CommentAddServiceModel commentAddServiceModel) {
        CommentEntity commentEntity = modelMapper.map(commentAddServiceModel, CommentEntity.class);

        String currentUserName = SecurityContextHolder.getContext().getAuthentication().getName();
        commentEntity.setAuthor(currentUserName);

        commentRepository.save(commentEntity);
    }

    @Override
    public CommentViewModel findById(Long id) {
        return commentRepository.findById(id)
                .map(commentEntity -> {
                    CommentViewModel commentViewModel = modelMapper
                            .map(commentEntity, CommentViewModel.class);
                    return commentViewModel;
                }).orElseThrow(IllegalArgumentException::new);
    }
}
