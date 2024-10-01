package como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.models.domain.User;

@Service
public class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = new ArrayList<>();
        users.add(new User(1L, "Diego", "Guerrero"));
        users.add(new User(2L, "Nahomy", "Revelo"));
        users.add(new User(3L, "Andres", "Perez"));
        users.add(new User(4L, "Camilo", "Lopez"));
        users.add(new User(5L, "Diana", "Bastidas"));
        users.add(new User(6L, "Alirio", "Guerrero"));
        users.add(new User(7L, "Lina", "Chaucanes"));
        users.add(new User(8L, "James", "Rodriguez"));
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        for (User u : users) {
            if (u.getId().equals(id)) {

                user = u;
                break;

            }
        }
        return user;

    }
}
