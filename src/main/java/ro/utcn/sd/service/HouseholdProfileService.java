package ro.utcn.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.utcn.sd.entity.HouseholdProfile;
import ro.utcn.sd.repository.HouseholdProfileRepository;

import java.util.List;
import java.util.Random;

public class HouseholdProfileService {
    @Autowired
    HouseholdProfileRepository householdProfileRepository;
    UserService userService;
    public void createNewHouseholdProfile(HouseholdProfile householdProfile){
        List<String> userIds = userService.getAllUserIds();
        Random rand = new Random();
        String randomId = userIds.get(rand.nextInt(userIds.size()));
        householdProfile.setUser(userService.findUserById(randomId));
        householdProfileRepository.save(householdProfile);
    }

}
