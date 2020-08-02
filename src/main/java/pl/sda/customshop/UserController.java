package pl.sda.customshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String userForm(Model model){
        model.addAttribute("Countries", Countries.values());
        Long countUsers = userService.countUsers();
        model.addAttribute("countUsers", countUsers);
        return "usersPage";
    }

    @PostMapping("/users")
    public String createUser(@RequestParam String firstName, String lastName, String email, String country, Model model){
        userService.addUser(new UserDTO(null, firstName, lastName, email, country));
        return "redirect:/users";

    }



}
