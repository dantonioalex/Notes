package Save.Notes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import Save.Notes.Interface.UserInterface;
import Save.Notes.Scanningdb.UserMapping;

@org.springframework.stereotype.Service
public class UsersService {
	
	@Autowired
	UserInterface userInterface;
	public void registerNewUser( @RequestParam(required = false) long id, @RequestParam(required = false) String username, @RequestParam(required = false)  String email,  @RequestParam(required = false) String password) throws Exception {
		  System.out.println(id);
		 if (id > 0  && username != "" && email != "" && password != "") {
		    	 List<UserMapping> userGiaRegistrato = userInterface.findUser(username, email);
		         if (userGiaRegistrato.size() == 0) {
		    		 UserMapping newUsers = new UserMapping(id, username, email, password);
					 userInterface.save(newUsers);
		    	}else {
		    		 throw new Exception("I paramentri non sono stati inizializati bene");
		    	}
		    	
		     }else {
		    	 throw new Exception("Utente non  registrato");
		     }
		    
	}
	
   public boolean getLogin(@RequestParam(required =  false) String username,@RequestParam(required =  false) String password){
	   List<UserMapping> checkUtente = userInterface.findUser(username, password);
	   if (checkUtente.size() == 1) {
		   return true;
	   }else {
		   return false;
	   }
	  
   }
	
}
