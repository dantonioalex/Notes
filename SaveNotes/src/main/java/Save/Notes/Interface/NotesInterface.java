package Save.Notes.Interface;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import java.util.List;

import Save.Notes.Scanningdb.NotesScanning;


@EnableJpaRepositories
public interface NotesInterface extends JpaRepository<NotesScanning, Long> {
	@Query(value ="SELECT * FROM  NOTES WHERE TITLE=:title OR DESCRIZIONE=:descrizione",nativeQuery = true)
	List<NotesScanning> findSpecificationNotes(@Param("title") String title,@Param("descrizione") String descrizione);
	
	
	@Query(value ="SELECT * FROM NOTES WHERE USERNAME=:username",nativeQuery=true)
	List<NotesScanning> getAllNotes(@Param("username") String username);
	
	
	@Query(value = "DELETE * FROM NOTES WHERE USERNAME=:username",nativeQuery=true)
	List<NotesScanning> deleteAll(@Param("username") String username);
}
