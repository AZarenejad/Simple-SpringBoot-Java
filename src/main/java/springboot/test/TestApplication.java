package springboot.test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springboot.test.model.Role;
import springboot.test.model.User;
import springboot.test.repository.RoleRepository;
import springboot.test.repository.UserRepository;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan({"springboot.test.controller"})
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }


//    @Bean
//    public CommandLineRunner mappingDemo(UserRepository userRepository, RoleRepository roleRepository) {
//        return args -> {
//
//            // create a new user
//            User user1 = new User("a", "a1", "123", "a@gmail.com", "09121234567");
//            User user2 = new User("b", "b1", "123", "b@gmail.com", "09121234567");
//            User user3 = new User("c", "c1", "123", "c@gmail.com", "09121234567");
//
//            // save the users
//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.save(user3);
//
//            // create and save new roles
//            Role role1 = new Role("role1");
//            Role role2 = new Role("role2");
//            Role role3 = new Role("role3");
//            roleRepository.save(role1);
//            roleRepository.save(role2);
//            roleRepository.save(role3);
//        };
//    }

}
