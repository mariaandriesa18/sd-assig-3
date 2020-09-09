package ro.utcn.sd.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.utcn.sd.api.ApiResponseFactory;
import ro.utcn.sd.entity.HouseholdProfile;
import ro.utcn.sd.service.HouseholdProfileService;

@RestController
@RequestMapping("/household_profile")
public class HouseholdProfileController {

    HouseholdProfileService householdProfileService;
    ApiResponseFactory apiResponseFactory ;

    @PostMapping("/create")
    public ResponseEntity createHouseholdProfile(@RequestBody HouseholdProfile householdProfile){
        if(householdProfile.getAddress().equals("") ){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Please insert an address.");
        }

        if (householdProfile.getNb_of_members().equals("")) {
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Please insert nb of members.");
        }

        householdProfileService.createNewHouseholdProfile(householdProfile);
        return apiResponseFactory.createSuccessMessage("Created a household profile.");
    }

}
