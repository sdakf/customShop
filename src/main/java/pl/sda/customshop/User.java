package pl.sda.customshop;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //nie wszystkie bazy danych mają sekwencję - np. MySQL nie ma
    private Long id;

    @Version
    private Long version;

    private String firstName;
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Countries country;

    public static User fromDto(UserDTO userDTO) {
        User user = new User();
        user.country = Countries.valueOf(userDTO.getCountry());
        user.email = userDTO.getEmail();
        user.firstName = userDTO.getFirstName();
        user.lastName = userDTO.getLastName();
        user.id = userDTO.getId();
        return user;
    }
}
