import { Component, Input, Output, OnInit, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { NotesServiceService } from '../notes/NotesService/notes-service.service';
import { RegisterAndLoginService } from '../register-and-login/LoginAndRegisterService/register-and-login.service';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css'],
})
export class NotesComponent implements OnInit {
  @Input() usermame: string = '';

  @Input() addClick: boolean = true;

  @Output() emiter: any = new EventEmitter();

  idNotes: number = 0;
  notesAdd: boolean = false;
  allNotes: any[] = [];
  arry:any[] = [];
  viewAllNotes: boolean = true;
  // Edit mode
  edit: boolean = false;
  id: string = '';
  titleNotes: string = '';
  descrizione: string = '';
  user: string = '';
  error: string = '';
  errorView: boolean = false;
  note:any = "";
  constructor(
    private notes: NotesServiceService,
    private login: RegisterAndLoginService,
    private router: Router
  ) {
    this.usermame = this.login.username;
  }

  ngOnInit(): void {
    if( this.usermame != ""){
      this.notes.loadAllNotes(this.usermame).subscribe((data: any) => {
        this.allNotes = data;
      });
    }else{
      this.router.navigate(['/'], { replaceUrl: true });
    }

  }

  clickAdd() {
    this.addClick = true;
    this.notesAdd = true;
    this.viewAllNotes = false;
    this.addClick = false;
  }
  addNotes(id: string, title: string, descizione: string) {
    console.log(id,title,descizione)
    this.notes.addNotes(parseInt(id), title, descizione, this.usermame).subscribe((data: any) => {
      this.allNotes.push(data);
      this.addClick = false;
      this.notesAdd = false;
      this.viewAllNotes = true;
      this.addClick = true;
    });
  }

  editMode(id: string, title: string, descizione: string, usermame: string) {
    this.edit = true;
    this.id = id;
    this.titleNotes = title;
    this.descrizione = descizione;
    this.user = usermame;
    this.viewAllNotes = false;
  }

  deleteAllNotes(user: string) {
    this.notes.notesUserDeleteAllNotes(this.usermame).subscribe((data: any) => {
      this.allNotes.splice(data);
    });
  }
  updateNotes(id: string, title: string, descizione: string, usermame: string) {
    this.notes.updateNote(parseInt(id), title, descizione, usermame).subscribe((data: any) => {  
      let note:any =this.allNotes;
      this.edit = false;
      this.addClick = false;
      this.notesAdd = false;
      this.viewAllNotes = true;
      this.addClick = true;
    
      this.allNotes = [];
      for (let notes of note){
        if (notes.id == data.id){
          this.allNotes.push(data);
        }else{
          this.allNotes.push(notes);
        }
      }
      
    });
  }

  deleteNotes(id: string, title: string, descizione: string, usermame: string) {
    let note:any= this.allNotes;
    this.notes.deleteNotes(parseInt(id), title, descizione, usermame).subscribe((data: any) => {
      console.log("Sono data : " + JSON.stringify(data));
      console.log(JSON.stringify(this.allNotes));
      this.allNotes = [];
      for (let notes of note){
        if (notes.id != data.id){
          this.allNotes.push(notes);
        }
      }
    //  this.allNotes.splice(data);
     
    });
  }

  logout() {
    this.usermame = '';
    this.router.navigate(['/'], { replaceUrl: true });
  }

  back() {
    this.addClick = false;
    this.notesAdd = false;
    this.viewAllNotes = true;
    this.addClick = true;
  }

  backEdit() {
    this.edit = false;
    this.addClick = false;
    this.notesAdd = false;
    this.viewAllNotes = true;
    this.addClick = true;
  }
}
