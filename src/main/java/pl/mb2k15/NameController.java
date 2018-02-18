package pl.mb2k15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2016-01-21
 */
//*/
@Controller
public class NameController  {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/greeting")
    public String greeting( @RequestParam(value="name" , defaultValue = "XXXX" , required = true)String name ,
                            @RequestParam(value="age", defaultValue = "20" , required = true)Integer age , Model model) {

        name = "Noname";
        age = 75;
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        model.addAttribute("resultm", number());


        return "greeting";

    }

    public List<String> number(){

         /*   String [] s = {"one" , "two" , "there"};

            List <String> list = new ArrayList<>(Arrays.asList(s));

            list.add("element");
            list.remove(2);


            return list;*/

         List <UserModel> listUserModel = (List<UserModel>) userRepository.findAll();
         List <String> listToreturnByMethod = listUserModel.stream()
                 .filter(s -> s.getUsrName().length() < 10)
                 .map(s -> s.getUsrName().toUpperCase())
                 .collect(Collectors.toList());

         return listToreturnByMethod;

    }




}
