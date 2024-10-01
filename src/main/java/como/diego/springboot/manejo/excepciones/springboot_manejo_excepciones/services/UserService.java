package como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.services;

import java.util.List;

import como.diego.springboot.manejo.excepciones.springboot_manejo_excepciones.models.domain.User;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

}
