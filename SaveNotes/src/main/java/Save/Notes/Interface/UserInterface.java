package Save.Notes.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import Save.Notes.Scanningdb.UserMapping;

@EnableJpaRepositories
public interface UserInterface  extends JpaRepository<UserMapping, Long>{
   @Query(value = "SELECT * FROM USERS WHERE username=:username and email = :email",nativeQuery = true)
   List<UserMapping> findUser(@Param("username") String username, @Param("email") String email);
}
