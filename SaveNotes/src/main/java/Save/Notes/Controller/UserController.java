package Save.Notes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Save.Notes.Interface.UserInterface;
import Save.Notes.Scanningdb.UserMapping;
import Save.Notes.Service.UsersService;

@CrossOrigin(origins= "*")
@RestController
public class UserController {
   @Autowired
   UsersService serviceUsers;
   
  

  @PostMapping("register")
  @ResponseBody
  public void  registerNewUsers(@RequestParam(required = false) long id,@RequestParam(required = false) String username,@RequestParam(required = false) String email,@RequestParam(required = false) String password) throws Exception {
	  serviceUsers.registerNewUser((long)id, username, email, password);
  }
  
  
  @GetMapping("login")
  @ResponseBody
  public boolean getLogin(@RequestParam(required = false) String username, @RequestParam(required = false) String password) {
	  return serviceUsers.getLogin(username, password);
  }
}
