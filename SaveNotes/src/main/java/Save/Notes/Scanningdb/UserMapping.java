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
//import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
public class UserMapping {
  @Id
  @Column
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private @Getter @Setter long id;
  
  @Column 
  private @Getter @Setter String username;
  
  
  @Column
  private @Getter @Setter String email;
  
  @Column
  private @Getter @Setter String password;
  
}
