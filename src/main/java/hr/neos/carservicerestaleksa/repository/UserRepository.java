package hr.neos.carservicerestaleksa.repository;

import hr.neos.carservicerestaleksa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
