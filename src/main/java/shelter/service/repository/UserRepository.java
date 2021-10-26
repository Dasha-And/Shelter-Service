package shelter.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shelter.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);
    User findUserByEmail(String email);
}
