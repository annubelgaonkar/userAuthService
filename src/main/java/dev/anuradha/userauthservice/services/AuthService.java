package dev.anuradha.userauthservice.services;

import dev.anuradha.userauthservice.exceptions.AccountSuspendedException;
import dev.anuradha.userauthservice.exceptions.PasswordMismatchException;
import dev.anuradha.userauthservice.exceptions.UserAlreadySignedException;
import dev.anuradha.userauthservice.exceptions.UserNotRegisteredException;
import dev.anuradha.userauthservice.models.State;
import dev.anuradha.userauthservice.models.User;
import dev.anuradha.userauthservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepo userRepo;

    public User register(String name, String email, String password){

        Optional<User> userOptional = userRepo.findByEmail(email);
        if(userOptional.isPresent()){
            throw new UserAlreadySignedException("Please try login directly");
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);

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
        if(!storedPassword.equals(password)){
            throw new PasswordMismatchException("Entered password is incorrect");
        }

        return userOptional.get();
    }
}
