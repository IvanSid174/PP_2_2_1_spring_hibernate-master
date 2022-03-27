package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
//      User user1 = new User("User3", "Lastname3", "user3@mail.ru");
//      User user2 = new User("User4", "Lastname4", "user4@mail.ru");
//
//      Car car1 = new Car("LADA",2010);
//      Car car2 = new Car("LADA",2015);
//      Car car3 = new Car("Toyota",2001);
//      Car car4 = new Car("KIA",2008);
//      user1.setCar(car3);
//      user2.setCar(car4);
//
//      userService.add(user2);
//      userService.add(user1);



      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car ="+ user.getCar());
         System.out.println();
      }
      User userCar = userService.getUserByCar("LADA",2010);
      System.out.println("First Name = "+userCar.getFirstName() + " Last Name = "+userCar.getLastName() + " Email = "+userCar.getEmail());

      context.close();
   }
}
