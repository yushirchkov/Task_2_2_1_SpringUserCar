package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Юрий", "Ширчков", "user1@mail.ru");
      User user2 = new User("Степан", "Степанов", "user2@mail.ru");
      User user3 = new User("Иван", "Иванов", "user3@mail.ru");
      User user4 = new User("Петр", "Петров", "user4@mail.ru");

      Car car1 = new Car("Лада", 2007);
      Car car2 = new Car("Москвич", 1998);
      Car car3 = new Car("ИЖ", 2010);
      Car car4 = new Car("Запорожец", 1989);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         if (user.getCar() != null) {
            System.out.println("Car = " + user.getCar());
         } else {
            continue;
         }
         System.out.println();
      }

      List<User> users2 = userService.listUsersAllCar("Москвич", 1998);
      for (User user : users2) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      context.close();
   }


}
