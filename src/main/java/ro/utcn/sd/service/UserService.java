package ro.utcn.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.utcn.sd.converter.UserDtoToUser;
import ro.utcn.sd.converter.UserToUserDto;
import ro.utcn.sd.dto.UserDto;
import ro.utcn.sd.entity.User;
import ro.utcn.sd.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void loadUser(UserDto userDto){
            User user = UserDtoToUser.convertUserDtoToUser(userDto);
            user.setUser_id(UUID.randomUUID().toString());
            user.setUser_type("regular");
            userRepository.save(user);
    }

    public List<UserDto> getAllRegularUser(){
        List<User> userList = userRepository.findAllRegularUsers();
        List<UserDto> userDtoList = new ArrayList<>();

        for(User user : userList){
            userDtoList.add(UserToUserDto.convertToUserDto(user));
        }
        return userDtoList;
    }

    public UserDto findUserByUsername(String username){
        User user = userRepository.findUserByUsername(username);
        return UserToUserDto.convertToUserDto(user);
    }

    public UserDto findUserByEmail(String email){
        User user = userRepository.findUserByEmail(email);
        return UserToUserDto.convertToUserDto(user);
    }

    public void updateUser(UserDto userDto, String username){

        if(!(userDto.getUsername() == null)){
            userRepository.updateUserUsername(userDto.getUsername(), username);
        }

        if(!(userDto.getName() == null)){
            userRepository.updateUserName(userDto.getName(), username);
        }

        if(!(userDto.getSurname()== null)){
            userRepository.updateUserSurname(userDto.getSurname(), username);
        }

        if(!(userDto.getEmail()== null)){
           userRepository.updateUserEmail(userDto.getEmail(), username);
        }

        if(!(userDto.getPassword()== null)){
            userRepository.updateUserPassword(userDto.getPassword(), username);
        }

    }

    public void deleteUserWithUsername(String username){
        userRepository.deleteUser(username);
    }

    List<String> getAllUserIds(){
        return userRepository.getAllUsersIds();
    }

    User findUserById(String id){
        return userRepository.findUsersByUser_id(id);
    }
}
