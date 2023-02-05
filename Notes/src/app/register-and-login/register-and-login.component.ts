import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import{RegisterAndLoginService} from "../register-and-login/LoginAndRegisterService/register-and-login.service"
import {DragDropModule} from "@angular/cdk/drag-drop";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-register-and-login',
  templateUrl: './register-and-login.component.html',
  styleUrls: ['./register-and-login.component.css']
})
export class RegisterAndLoginComponent implements OnInit {
  idPost:number = 1;
  visibilita:boolean = false;
  registrati: boolean = false;
  accedi:boolean = false;
  username:string = "";
  error:string = "";
  allNotes :any;
  viewAllNotes:boolean = false;
  notes:boolean = true;
  objectDragAndDrop  = new DragDropModule();


  @Input() click:boolean = false;
  @Output() emitUser:any  =  new EventEmitter();
  
  constructor(private service:RegisterAndLoginService,private router:Router,private activateRoute:ActivatedRoute) {
 
  }

  ngOnInit(): void {
  }
  startRegister(){
    this.visibilita=true;
    this.notes = false;
    this.registrati = true;
  }

  Register(id:string,username:string,email:string,password:string){
    this.service.registerNewUser(parseInt(id),username,email,password).subscribe(
      (data:any) =>{
        window.location.reload();
      }
    )
  }

  logincheck(){
    this.visibilita= true;
    this.accedi = true;
    this.notes = false;
  }
  getLogin(username:string,password:string){
    this.visibilita= true;
    this.service.checkLogin(username,password).subscribe(
      (data:any) =>{
        if (data == false){
          this.viewAllNotes = true;
          this.error  = "Account non esistente "
        }else{
          this.username = username;
          this.emitUser.emit(this.username);
          this.accedi = false;
          this.visibilita= true;
          this.service.username = this.username;
          this.router.navigate(["notes"],{ replaceUrl: true})
        }
      }
    )
   
  }
}
