package com.travelpoint.service.impl;

import com.travelpoint.model.entity.UserEntity;
import com.travelpoint.model.entity.UserRoleEntity;
import com.travelpoint.model.entity.enums.UserRole;
import com.travelpoint.model.service.UserRegistrationServiceModel;
import com.travelpoint.repository.UserRepository;
import com.travelpoint.repository.UserRoleRepository;
import com.travelpoint.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final TravelPointUserService travelPointUserService;

    public UserServiceImpl(UserRoleRepository userRoleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, TravelPointUserService travelPointUserService) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.travelPointUserService = travelPointUserService;
    }


    @Override
    public void seedUsers() {

        if (userRepository.count() == 0) {

            UserRoleEntity adminUserRoleEntity = new UserRoleEntity().setRole(UserRole.ADMIN);
            UserRoleEntity moderatorRoleEntity = new UserRoleEntity().setRole(UserRole.MODERATOR);
            UserRoleEntity userRoleEntity = new UserRoleEntity().setRole(UserRole.USER);

            userRoleRepository.saveAll(List.of(adminUserRoleEntity, moderatorRoleEntity, userRoleEntity));

            UserEntity admin = new UserEntity().setUsername("admin").setEmail("admin@abv.bg").setPassword(passwordEncoder.encode("12345"));
            UserEntity moderator = new UserEntity().setUsername("moderator").setEmail("mod@abv.bg").setPassword(passwordEncoder.encode("12345"));
            UserEntity user = new UserEntity().setUsername("user").setEmail("user@abv.bg").setPassword(passwordEncoder.encode("12345"));
            admin.setUserRoleEntity(List.of(adminUserRoleEntity, moderatorRoleEntity, userRoleEntity));
            moderator.setUserRoleEntity(List.of(moderatorRoleEntity, userRoleEntity));
            user.setUserRoleEntity(List.of(userRoleEntity));

            userRepository.saveAll(List.of(admin, moderator, user));
        }
    }

    @Override
    public void registerAndLoginUser(UserRegistrationServiceModel serviceModel) {
        UserEntity newUserEntity = modelMapper.map(serviceModel, UserEntity.class);
        newUserEntity.setPassword(passwordEncoder.encode(serviceModel.getPassword()));

        UserRoleEntity userRoleEntity = userRoleRepository.
                findByRole(UserRole.USER).orElseThrow(
                () -> new IllegalStateException("USER role not found. Please seed the roles."));

        newUserEntity.addRole(userRoleEntity);

        newUserEntity = userRepository.save(newUserEntity);

        UserDetails principal = travelPointUserService.loadUserByUsername(newUserEntity.getUsername());

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                newUserEntity.getPassword(),
                principal.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Override
    public boolean userNameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public void changeUserRoleByUserId(Long id) {
        UserRoleEntity userRoleEntity = userRoleRepository.findByRole(UserRole.USER).orElse(null);
        UserRoleEntity adminUserRoleEntity = userRoleRepository.findByRole(UserRole.ADMIN).orElse(null);

        //TODO: mod
        UserEntity user = userRepository.findById(id).orElse(null);

        assert user != null;
        if(user.getUserRoleEntity().size() == 2) {
            assert userRoleEntity != null;
            user.setUserRoleEntity(List.of(userRoleEntity));
        } else {
            assert adminUserRoleEntity != null;
            assert userRoleEntity != null;
            user.setUserRoleEntity(List.of(adminUserRoleEntity, userRoleEntity));
        }

        userRepository.save(user);
    }
}
