package usersservice;

import org.springframework.data.jpa.repository.JpaRepository;

import usersservice.model.CustomUser;

public interface CustomUserRepository extends JpaRepository<CustomUser, Long>{
	
	CustomUser findByEmail(String email);

}
