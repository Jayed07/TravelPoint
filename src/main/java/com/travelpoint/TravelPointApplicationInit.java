package com.travelpoint;

import com.travelpoint.service.RegionService;
import com.travelpoint.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TravelPointApplicationInit implements CommandLineRunner {

    private final UserService userService;
    private final RegionService regionService;

    public TravelPointApplicationInit(UserService userService, RegionService regionService) {
        this.userService = userService;
        this.regionService = regionService;
    }

    public void run (String... args) throws Exception {
        userService.seedUsers();
        regionService.seedRegions();
    }
}
