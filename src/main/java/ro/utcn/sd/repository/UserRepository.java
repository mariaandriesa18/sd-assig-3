package ro.utcn.sd.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import ro.utcn.sd.entity.User;

import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

        @Query("SELECT u FROM User u WHERE u.user_type = 'regular'")
        List<User> findAllRegularUsers();

        @Query("SELECT u.user_id FROM User u WHERE u.user_type = 'regular'")
        List<String> getAllUsersIds();
        @Query("select u from User u where u.user_id = :id")
        User findUsersByUser_id(@Param("id") String id);

        @Query("select u from User u where u.user_name = :username")
        User findUserByUsername(@Param("username")String username);

        @Query("select u from User u where u.email = :email")
        User findUserByEmail(@Param("email")String email);

        @Transactional
        @Modifying
        @Query("Update User u set u.user_name = :new_username where u.user_name = :username")
        void updateUserUsername(@Param("new_username") String new_username, @Param("username") String username);

        @Transactional
        @Modifying
        @Query("Update User u set u.name = :new_name where u.user_name = :username")
        void updateUserName(@Param("new_name") String new_name, @Param("username") String username);

        @Transactional
        @Modifying
        @Query("Update User u set u.surname = :new_surname where u.user_name = :username")
        void updateUserSurname(@Param("new_surname") String new_surname, @Param("username") String username);

        @Transactional
        @Modifying
        @Query("Update User u set u.email = :new_email where u.user_name = :username")
        void updateUserEmail(@Param("new_email") String new_email, @Param("username") String username);

        @Transactional
        @Modifying
        @Query("Update User u set u.password = :new_password where u.user_name = :username")
        void updateUserPassword(@Param("new_password") String new_password, @Param("username") String username);

        @Transactional
        @Modifying
        @Query("delete from User u where u.user_name = :username")
        void deleteUser(@Param("username") String username);
}
