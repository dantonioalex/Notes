import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  username:string = ""
  addNotes:boolean = false;

  usernameEmiter($event:string){
    this.username = $event;
    console.log( "Questo é l'emiter" ,this.username)
    this.addNotes = true;
  }
}
