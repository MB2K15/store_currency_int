package pl.mb2k15;


import groovy.util.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

@Controller
public class CartController {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CartController.class);

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/warehouse/addproducttocart", method = RequestMethod.POST)

    public String addToCart(@RequestParam(value = "productId") Integer productId, Model model, HttpSession session) {
        List<ProductModel> lista = (List<ProductModel>) session.getAttribute("productlist");
        System.out.println("Adding product=======>>>>>>>>");
        if (lista==null) {

            lista = new ArrayList<>();
            session.setAttribute("productlist", lista);

        }

        ProductModel product = productRepository.findOne(productId);
        lista.add(product);

        System.out.println("------------------"+lista);

        model.addAttribute("productlist", lista);
        model.addAttribute("total" , getAll(lista));
        return "upcart";
    }

    @RequestMapping(value = "/warehouse/remove" , method=RequestMethod.GET)
    public String removeProductfromCart(@RequestParam(value = "id") Integer id,HttpSession session,
                                        Model model) {
        System.out.println("Delete product=======>>>>>>>>");
        List<ProductModel> cartproductlist = (List<ProductModel>) session.getAttribute("productlist");

        if (cartproductlist != null) {

            Iterator<ProductModel> iterator = cartproductlist.iterator();

            while (iterator.hasNext()) {
                ProductModel productModel = iterator.next();
                if (Objects.equals(productModel.getId(),id)) {
                    iterator.remove();
                    break;

                }
            }

        }


   model.addAttribute("productlist" ,cartproductlist);
        model.addAttribute("total" , getAll(cartproductlist));


        return "upcart";
    }

    @RequestMapping(value="warehouse/resultcartcontent")
    public String showResultCart(){

        return "resultcartcontent";

    }

    public float getAll(List<ProductModel> listproduct) {
        System.out.println("GetALL Working already=======>>>>>>>>");
        float allcostproducts = 0;

        for (ProductModel product : listproduct) {

            allcostproducts += product.getNumber() * product.getPrice();

        }

        return allcostproducts;

    }


}
