import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterAndLoginComponent } from './register-and-login/register-and-login.component';
import { NotesComponent } from './notes/notes.component';
import { RouterModule, Routes } from '@angular/router';
import {DragDropModule} from "@angular/cdk/drag-drop";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { APP_BASE_HREF } from '@angular/common';





@NgModule({
  declarations: [
    AppComponent,
    RegisterAndLoginComponent,
    NotesComponent,
  ],

  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    BrowserAnimationsModule,
    DragDropModule,
  ],
  bootstrap: [AppComponent],
  exports: [RouterModule],


})
export class AppModule { }
