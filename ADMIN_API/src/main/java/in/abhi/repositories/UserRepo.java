package in.abhi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.abhi.entities.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	@Query("update UserEntity set accStatus=:status where userId=:userId")
	public Integer updateAccStatus(Integer userId, String status);
	
	public UserEntity findByEmail(String email);
}
