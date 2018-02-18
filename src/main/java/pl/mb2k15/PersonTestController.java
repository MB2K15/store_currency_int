package pl.mb2k15;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.IOException;


/**
 * Created by Matt on 2017-07-05.
 */
@Controller
public class PersonTestController {


    @RequestMapping(value = "/addUserModel", method = RequestMethod.POST)
    public String submit(@ModelAttribute("usermodel")UserModel userModel,
                          Model model){

        model.addAttribute("id", userModel.getUsrId());
        model.addAttribute("name", userModel.getUsrName());


        return "greeting";


    }

    @RequestMapping(value = "/currency")
    public String currentlyCurrencyValue(
            @RequestParam(value="currency_state" , defaultValue = "XXXX" , required = true) String currency_state,
            Double rate,
            @ModelAttribute("currency") Currency currency, Model model) throws IOException {


        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ObjectMapper objectMapper = new ObjectMapper();
        currency = objectMapper.readValue(classLoader.getResource("currency.json"), Currency.class);

        model.addAttribute("currency_state", currency.getCurrency());
        model.addAttribute("rate", currency.getRates().get(0).getMid());

        return "greeting";
    }
}
