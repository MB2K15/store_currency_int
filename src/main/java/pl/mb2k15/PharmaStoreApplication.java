package pl.mb2k15;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;


@SpringBootApplication
public class PharmaStoreApplication {

    //private static final Logger log = LoggerFactory.getLogger(PharmaStoreApplication.class);



    public static void main(String[] args) {

        SpringApplication.run(PharmaStoreApplication.class, args);



    }

    @Bean
    public CommandLineRunner demo(UserRepository repository , ProductRepository productRepository) {
        return (args) -> {

            System.out.println("Making repositories=======--------");

            repository.save(new UserModel("user", "root"));
            repository.save(new UserModel("root", "user1"));
            repository.save(new UserModel("mateusz" ,"123"));
            repository.save(new UserModel("uzytkownik" ,"007"));

            productRepository.save(new ProductModel.Builder("Bullet medical")
            .category("mediacal").file("wozek.jpg")
            .price(125.67f).number(2).build());
            productRepository.save(new ProductModel.Builder("Bullet medical")
                    .category("mediacal").file("bed.jpeg")
                    .price(225.70f).number(2).build());
            productRepository.save(new ProductModel.Builder("Bullet medical")
                    .category("mediacal").file("kula.jpg")
                    .price(5.90f).number(2).build());
           /* productRepository.save(new ProductModel("Bullet medical Evolution" , "MEDICAL" , 25 , 1 , "kula.jpg"));
            productRepository.save(new ProductModel("Wheelchair VERMEIREN" , "MEDICAL" , 1700.90f , 1 , "wozek.jpg"));
            productRepository.save(new ProductModel("Bed rehabilitation" , "MEDICAL" , 1899.90f , 1 , "bed.jpeg"));
            productRepository.save(new ProductModel("Bed rehabilitation" , "MEDICAL" , 1899.90f , 1 , "bed.jpeg"));*/

            List<UserModel> byUsrNameAndUsrPasswd = repository.findByUsrNameAndUsrPasswd("user", "root");


            for(UserModel userModel : repository.findAll())
            {
                repository.findAll().forEach(System.out::println);
            }



            /*log.info(byUsrNameAndUsrPasswd.toString());

            for (UserModel user : repository.findAll())
                log.info(user.toString());

            for(ProductModel product : productRepository.findAll())

            {

                log.info(product.toString());

            }
            */
        };
    }
}
