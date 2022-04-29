package com.travelpoint.service;

import com.travelpoint.model.service.UserRegistrationServiceModel;

public interface UserService {

    void seedUsers();

    void registerAndLoginUser(UserRegistrationServiceModel serviceModel);

    boolean userNameExists(String username);

    void changeUserRoleByUserId(Long id);
}
