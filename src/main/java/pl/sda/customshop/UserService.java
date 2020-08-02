package pl.sda.customshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(UserDTO userDTO) {
        boolean userExists = userRepository.findByLogin(userDTO.getEmail())
                .isPresent();

        if (userExists) {
            throw new RuntimeException("Użytkownik istnieje");
        }

        User user = User.fromDto(userDTO);
        userRepository.save(user);
    }


    public Long countUsers() {
        return userRepository.count();
    }
}
