package ro.utcn.sd.converter;

import ro.utcn.sd.dto.UserDto;
import ro.utcn.sd.entity.User;

public class UserToUserDto {

    public static UserDto convertToUserDto(User user){
        UserDto userDto = new UserDto(
                            user.getName(),
                            user.getSurname(),
                            user.getUser_name(),
                            user.getEmail(),
                            user.getPassword());
        return userDto;

    }
}
