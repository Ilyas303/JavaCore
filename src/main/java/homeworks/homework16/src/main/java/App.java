import model.User;
import repository.UsersRepository;
import repository.impl.UsersRepositoryFileImpl;

public class App {
    public static void main(String[] args) {
        UsersRepository repository = new UsersRepositoryFileImpl();


        User user = new User(" trunoisemc_99", "789ghs", "789ghs", "Крылов", "Виктор", "Павлович", 25, true);
        repository.create(user);


        User foundUser = repository.findById(user.getId());
        System.out.println("Найден пользователь: " + foundUser);


        System.out.println("Все пользователи: " + repository.findAll());

    }
}
