package Save.Notes.Scanningdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NOTES")
@AllArgsConstructor
@NoArgsConstructor
public class NotesScanning {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Getter @Setter  long id;
	@Column
	private @Getter @Setter String title;
	
	@Column
	private @Getter @Setter String descrizione;
	
	@Column
	private @Getter @Setter String username;

}
