package ro.utcn.sd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.api.ApiResponseFactory;
import ro.utcn.sd.dto.UserDto;
import ro.utcn.sd.service.UserService;
import ro.utcn.sd.utils.UtilityClass;
import ro.utcn.sd.validators.UserValidator;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

     UserValidator userValidator = new UserValidator();
     @Autowired
    private UserService userService = new UserService();

     ApiResponseFactory apiResponseFactory = new ApiResponseFactory();
     UtilityClass util = new UtilityClass();

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto){

        if(userDto.getName().equals("")){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "You must provide a name.");
        }

        if(userDto.getSurname().equals("")){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "You must provide a surname.");
        }

        if(userDto.getUsername().equals("")){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "You must provide a username.");
        }

        if(userDto.getEmail().equals("")){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Email field is empty.");
        }

        if(!userValidator.validEmail(userDto.getEmail())){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "The email has a wrong format" );
        }

        if(userDto.getPassword().equals("")){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Password field is empty.");
        }

        if(!userValidator.validPassword(userDto.getPassword())){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "The password has a wrong format. " +
                    "It should have at least one lower case and one upper case letter, at least 1 number and " +
                    "it must be between 1 and 8 characters.");
        }
        List<UserDto> userDtoList = userService.getAllRegularUser();

        if(userValidator.existingFeature("username", userDto.getUsername(), userDtoList)){
            return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(),"This username already exists. Please choose another username.");
        }

        userService.loadUser(userDto);
        return apiResponseFactory.createSuccessMessage("everything is fine");
    }

    @PostMapping("/login")
     public ResponseEntity loginUser(@RequestBody UserDto userDto){
            List<UserDto> userDtoList = userService.getAllRegularUser();

            if(userDto.getEmail().equals("")){

                return apiResponseFactory.createWarningMessage(HttpStatus.BAD_REQUEST.value(), "You must provide a username.");
            }

            if(!userValidator.existingFeature("email", userDto.getEmail(), userDtoList)){
                return apiResponseFactory.createWarningMessage(HttpStatus.CONFLICT.value(), "This email doesn't exist. Please register.");
            }

            UserDto userDto1 = userService.findUserByEmail(userDto.getEmail());
            if(userDto.getPassword().equals("")){
                return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Please introduce the password.");
            }
            if(!userDto.getPassword().equals(userDto1.getPassword())){
                return apiResponseFactory.createWarningMessage(HttpStatus.CONFLICT.value(), "Wrong password.");
            }
        return apiResponseFactory.createSuccessMessage("You have been logged in successfully.");
    }

    @GetMapping("/username/{username}")
    public UserDto getUserWithUsername(@PathVariable String username){
        username = util.removeParantheses(username);
        UserDto userDto = userService.findUserByUsername(username);
        return userDto;
    }

     @GetMapping("/email/{email}")
     public UserDto getUserWithEmail(@PathVariable String email){
        email = util.removeParantheses(email);
         UserDto userDto = userService.findUserByEmail(email);
         return userDto;
     }

     @PatchMapping("/edit/{username}")
     public ResponseEntity editUser(@PathVariable String username, @RequestBody UserDto userDto){

         List<UserDto> userDtoList = userService.getAllRegularUser();
         username = util.removeParantheses(username);
         UserDto userDto1 = userService.findUserByUsername(username);

        if(userDto1 == null){
            return apiResponseFactory.createWarningMessage(HttpStatus.BAD_REQUEST.value(), "User doesn't exist.");
        }

        if(!(userDto.getEmail() == null )){
            if(!userValidator.validEmail(userDto.getEmail())){
                return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "New Email does not respect " +
                        "the format");
            }
        }

        if(!(userDto.getPassword() == null)){
            if(!userValidator.validPassword(userDto.getPassword())){
                return apiResponseFactory.createWarningMessage(HttpStatus.NOT_ACCEPTABLE.value(), "The new password does not have a correct format");
            }
        }

        userService.updateUser(userDto, username);

        return apiResponseFactory.createSuccessMessage("Successfully edited the user data!");

     }

     @DeleteMapping("/delete/{username}")
     public ResponseEntity deleteUser(@PathVariable String username){
        username = util.removeParantheses(username);
        List<UserDto> userDtoList = userService.getAllRegularUser();
        if(!userValidator.existingFeature("username", username, userDtoList)){
            return apiResponseFactory.createWarningMessage(HttpStatus.CONFLICT.value(), "The user to be deleted does not exist.");
        }
        userService.deleteUserWithUsername(username);
        return apiResponseFactory.createSuccessMessage("The user has been deleted successfully!");

     }


}
