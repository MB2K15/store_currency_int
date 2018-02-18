package pl.mb2k15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class AddNewUserController {

    @Autowired
    private UserRepository userRepository;



    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String doActions(@ModelAttribute UserModel usr) {
       userRepository.save(usr);
        return "home";
    }


}
