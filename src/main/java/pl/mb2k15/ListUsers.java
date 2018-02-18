package pl.mb2k15;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by Matt on 2017-05-09.
 */
@RestController
//@RequestMapping("employees")
public class ListUsers {


    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private  ProductRepository productRepository;

    @RequestMapping(value = "getUsers" , method=RequestMethod.GET)
    public List<UserModel> userModelList (){

        List<UserModel> users = new ArrayList<UserModel>();

        users.add(new UserModel("root", "3456"));
        users.add(new UserModel("anna", "annab"));
        users.add(new UserModel("john123", "haslo123"));
        users.add(new UserModel("88ul", "NowaWies45"));
        users.add(new UserModel("cieplak" , "007agent"));

        return users;
    }

    @RequestMapping(value = "findAnyUser" ,  method=RequestMethod.GET)
    public UserModel findAnyUser(){
        return userRepository.findByUsrName("root");
    }

    @RequestMapping (value="findAll", method = RequestMethod.GET)
    public Set <UserModel> findAll() {
        List<UserModel>list = (List<UserModel>) userRepository.findAll();
        Set <UserModel> userModels = new HashSet<UserModel>(list);
        userModels.stream().sorted().distinct();
        return userModels;
    }

    @RequestMapping(value = "findSomething")
    public List <UserModel> findNameUser (){
        List <UserModel> lista = (List <UserModel>)userRepository.findAll();
        lista = lista.stream()
                .filter(s -> s.getUsrName().startsWith("m"))
                .collect(Collectors.toList());

        return lista;

     }

   @RequestMapping(value="users/{login}", method=RequestMethod.GET)
   UserModel findUserByLogin (@PathVariable("login") String usrLogin){
       return (UserModel) userRepository.findByUsrName(usrLogin);
   }

   @RequestMapping(value = "users/print")
    public List <String> ListUsers() {
       List <UserModel> listTest =(List <UserModel>)userRepository.findAll();
       List <String> listTest2 = listTest.stream()
               .filter(element -> element.getUsrName().length() > 5)
               .map(g->g.getUsrName())
               .sorted()
               .distinct()
               .collect(Collectors.toList());

       return listTest2;
    }

   @RequestMapping ("productList")
    List <ProductModel> findAllAccesProducts(){
        return (List <ProductModel>)productRepository.findAll();
   }

   @RequestMapping(value="findProduct")
   List<ProductModel> findInfo() {
       return productRepository.getByDescrription();
   }

   @RequestMapping(value = "returnfalse")
   public boolean findBoolean (){
      if (new Boolean("")==new Boolean(""))
          return true;
      else
          return false;
   }
}
