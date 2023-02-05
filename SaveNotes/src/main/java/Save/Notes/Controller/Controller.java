package Save.Notes.Controller;

import Save.Notes.Scanningdb.NotesScanning;
import Save.Notes.Service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins= "*")
@RestController
public class Controller {
	
 @Autowired	
 Service service;
 
 
 // Add and Update Notes 
 @PostMapping("InsertnewNotes")
 @ResponseBody
 public NotesScanning InsertnewNotes(@RequestParam(required = false) long  id,@RequestParam(required = false) String title, @RequestParam(required = false) String descrizione,@RequestParam(required = false) String username) throws Exception {
	  return service.newNotes(id, title, descrizione,username);
 }
 
 @PutMapping("UpdateNotes")
 @ResponseBody
 public NotesScanning UpdateNotes(@RequestParam(required = false) long  id,@RequestParam(required = false)  String title,@RequestParam(required = false)  String descrizione,@RequestParam(required = false)  String username) throws Exception{
	  return service.updateNotes((long) id, title, descrizione,username);
 }
 
  // Delete Mapping with  delete query 
 @DeleteMapping("DeleteNotes")
 @ResponseBody
 public NotesScanning DeleteNotes(@RequestParam long  id,@RequestParam String title, @RequestParam String descrizione,@RequestParam String username) {
	  return service.deleteNotes(id, title, descrizione,username);
 }
 
 
 @DeleteMapping("DeleteAllNotes")
 @ResponseBody
 public List<NotesScanning> DeleteAllNotes(@RequestParam(required = false) String username) {
	 return  service.deleteAllNotes(username);
 }
 
 // Find and Fatch all notes
 @GetMapping("AllNotes")
 @ResponseBody
 public List<NotesScanning> allNotes(@RequestParam String username){
	 return service.allNotes(username);
 }
 @GetMapping("GetNotes")
 @ResponseBody
 public List<NotesScanning> findSpecificationNotes(@RequestParam(required = false) String title, @RequestParam(required = false) String descrizione) throws Exception {
	 return (List<NotesScanning>) service.findSpecificationNotes(title, descrizione);
	 
 }
}
