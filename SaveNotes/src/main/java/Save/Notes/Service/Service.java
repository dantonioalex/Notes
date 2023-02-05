package Save.Notes.Service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import Save.Notes.Interface.NotesInterface;
import Save.Notes.Scanningdb.NotesScanning;

@org.springframework.stereotype.Service
public class Service {
   //Logger  mi va a fare dei log 
	private static final Logger log = LoggerFactory.getLogger(Service.class);
  
  //Auto wired dell ' interfaccia si stabilisce
  @Autowired
  NotesInterface notesInterface;
  
  
  // Aggiunge una nota
  public  NotesScanning newNotes( @RequestParam(required = false) long  id, @RequestParam(required = false)String title, @RequestParam(required = false) String descrizione, @RequestParam(required = false)String username) throws Exception {
	  System.out.println(id + " " + title + " "  + descrizione);
	  if (title != "" && descrizione != "") {  
		  NotesScanning newNotes = new NotesScanning(id, title, descrizione,username);
		  notesInterface.save(newNotes);
		  return newNotes;
	  }else {
		  throw new Exception("I parametri non sono tutti compilati");
	  } 
  }
  
  // Elimina una nota specifica
  public NotesScanning  deleteNotes(@RequestParam(required = false) long  id,@RequestParam(required = false) String title,@RequestParam(required = false) String descrizione, @RequestParam(required = false) String username) {
	  NotesScanning notesDelete = new NotesScanning(id, title, descrizione,username);
	  notesInterface.delete(notesDelete);
	  return notesDelete;
  }
  
  
  // Elimina tutte le note 
  
  public List<NotesScanning>  deleteAllNotes(@RequestParam(required = false) String username) {
	  return (List<NotesScanning>)  notesInterface.deleteAll(username);
  }
  
  // Controlla tutte le note
  public List<NotesScanning> allNotes(@RequestParam(required = false) String username){
	  return (List<NotesScanning>) notesInterface.getAllNotes(username);
  }
  
  
  // Find  Specification notes 
  
  public List<NotesScanning> findSpecificationNotes(String title,String descrizone) throws Exception{
	  
	  if ( !title.equals("") && !descrizone.equals("")) {
		  return (List<NotesScanning>) notesInterface.findSpecificationNotes(title, descrizone);
	  }else {
		  throw new Exception("Parola chiaven nulla");
	  }

  } 
  
  
  
  // Update Notes  BY ID
  
  public NotesScanning  updateNotes( @RequestParam(required = false)long  id, @RequestParam(required = false) String title, @RequestParam(required = false) String descrizione, @RequestParam(required = false) String username) throws Exception {
	  if (id > 0 &&  title != "" && descrizione!= "" && username != "") {
		  NotesScanning newNotes = new NotesScanning((long) id, title, descrizione,username);
		  notesInterface.save(newNotes);
		  return newNotes;
	  }else {
		  throw new Exception("I parametri non sono tutti compilati");
	  } 
  }
}
