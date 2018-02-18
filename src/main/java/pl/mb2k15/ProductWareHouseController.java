package pl.mb2k15;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Created by Matt on 2015-10-04.
 */


@Controller
public class ProductWareHouseController {

    @Autowired
    private ProductRepository productRepository;

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProductWareHouseController.class);

    @RequestMapping(value = "/warehouse/addProduct", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute ProductModel product, @RequestParam("uploadedFile") MultipartFile file) {


        File resourcesPath = new File("C:/photos/");
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                File destinationPath = new File(resourcesPath, file.getOriginalFilename());
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(destinationPath));
                stream.write(bytes);
                stream.close();

                product.setFile(name);

                productRepository.save(product);

                return "redirect:/warehouse/list";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    @RequestMapping("warehouse/list")
    public String getAllProducts(Model model) {


        Iterable<ProductModel> listproduct = productRepository.findAll();

        model.addAttribute("listproducts", listproduct);


        return "warehouse/productList";
    }


}
