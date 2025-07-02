package dev.anuradha.userauthservice.services;

import dev.anuradha.userauthservice.exceptions.AccountSuspendedException;
import dev.anuradha.userauthservice.exceptions.PasswordMismatchException;
import dev.anuradha.userauthservice.exceptions.UserAlreadySignedException;
import dev.anuradha.userauthservice.exceptions.UserNotRegisteredException;
import dev.anuradha.userauthservice.models.State;
import dev.anuradha.userauthservice.models.User;
import dev.anuradha.userauthservice.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {

    private UserRepo userRepo;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User register(String name, String email, String password){

        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadySignedException("User already registered,please try login directly");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepo.save(user);

    }

    public User login(String email, String password){
        Optional<User> userOptional = userRepo.findByEmail(email);

        if(userOptional.isEmpty()){
            throw new UserNotRegisteredException("Please register first");
        }

        if(!userOptional.get().getState().equals(State.ACTIVE)){
            throw new AccountSuspendedException(
                    "User account is temporarily suspended, please try after some days");
        }

        String storedPassword = userOptional.get().getPassword();
     //   if(!storedPassword.equals(password)){

            if(!bCryptPasswordEncoder.matches(password, storedPassword)){
                throw new PasswordMismatchException("Entered password is incorrect");
            }

        return userOptional.get();
    }
}
