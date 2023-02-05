import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import { RouterLink } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class NotesServiceService {
  
  requestPost:FormData = new FormData;

  updateNotes:FormData = new FormData;
  constructor(private http:HttpClient) { }


  addNotes(id:number,title:string,descizione:string,username:string):Observable<any>{
    console.log(id,title,descizione);
    this.requestPost = new FormData();
    this.requestPost.append("id",id.toString());
    this.requestPost.append("title",title);
    this.requestPost.append("descrizione",descizione);
    this.requestPost.append("username",username);
    console.log("Gino pippo : " + JSON.stringify(this.requestPost));
    return this.http.post("http://localhost:9000/InsertnewNotes",this.requestPost);
  }


  
  loadAllNotes(username:string):Observable<any>{
    return this.http.get("http://localhost:9000/AllNotes?username=" +username);
  }



  updateNote(id:number,title:string,descrizione:string,usermame:string):Observable<any>{
    this.updateNotes = new FormData();
    this.updateNotes.append("id",id.toString());
    this.updateNotes.append("title",title);
    this.updateNotes.append("descrizione",descrizione);
    this.updateNotes.append("username",usermame);

    return this.http.put("http://localhost:9000/UpdateNotes",this.updateNotes);
  }

  notesUserDeleteAllNotes(username:string):Observable<any>{
    return  this.http.delete<any>("http://localhost:9000/DeleteAllNotes?username="+username);
  }

  deleteNotes(id:number,title:string,descrizione:string,usermame:string):Observable<any>{
    console.log(id,title,descrizione);
    return  this.http.delete<any>("http://localhost:9000/DeleteNotes?id="+id+"&title="+title +"&descrizione="+descrizione+"&username="+usermame)
  }
}
