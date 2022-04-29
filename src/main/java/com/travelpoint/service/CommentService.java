package com.travelpoint.service;

import com.travelpoint.model.service.CommentAddServiceModel;
import com.travelpoint.model.view.CommentViewModel;

public interface CommentService {

    void add (CommentAddServiceModel commentAddServiceModel);

    CommentViewModel findById(Long id);
}
