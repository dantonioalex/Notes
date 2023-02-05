import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegisterAndLoginService {
  public username:string = "";
  datiRegister:FormData = new FormData;
  updateNotes:FormData = new FormData;
  constructor(private http:HttpClient) { }


  registerNewUser(id:number,username:string,email:string,password:string):Observable<any>{
    this.datiRegister.append("id",id.toString());  
    this.datiRegister.append("username",username);
    this.datiRegister.append("email",email);
    this.datiRegister.append("password",password);
    // Return request post
    return this.http.post<any>("http://localhost:9000/register" , this.datiRegister);
  }


  checkLogin(username:string,password:string):Observable<any>{
    return this.http.get<any>("http://localhost:9000/login?username="+username +"&password="+password);
  }
}
