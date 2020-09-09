package ro.utcn.sd.converter;
import ro.utcn.sd.dto.UserDto;
import ro.utcn.sd.entity.User;

public class UserDtoToUser {

    public static User convertUserDtoToUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setUser_name(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setSurname(userDto.getSurname());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
