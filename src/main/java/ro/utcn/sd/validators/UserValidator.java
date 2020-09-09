package ro.utcn.sd.validators;

import org.springframework.stereotype.Component;
import ro.utcn.sd.dto.UserDto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public UserValidator() { }

    public boolean validPassword(String password){
        /*
        String pattern = "((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z]).{1,8})";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);*/
        return true;
    }

    public boolean validEmail(String email){
        String pattern = "^(.+)@(.+)$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(email);
        return m.matches();

    }

    public boolean existingFeature(String featureType ,String feature, List<UserDto> userDtoList){

        if(featureType.equals("username")) {
            for (UserDto ud : userDtoList) {
                if (feature.equals(ud.getUsername())) {
                    return true;
                }

            }
        }

        if(featureType.equals("email")){
            for(UserDto ud : userDtoList){
                 if(feature.equals(ud.getEmail())){
                     System.out.println("FMMM");
                        return true;
                 }
            }
         }


        return false;
    }
}
