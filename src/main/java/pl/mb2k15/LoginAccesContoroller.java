package pl.mb2k15;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Matt on 2015-10-10.
 */

public class LoginAccesContoroller {

    @RequestMapping(value="/login")
    public String showPorductList(){

        return"redirect:/warehouse/list";
    }

}
