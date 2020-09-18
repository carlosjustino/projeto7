import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { backendProvider } from './_helpers';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TarefasComponent } from './tarefas/tarefas.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    TarefasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule
  ],
  providers: [
  backendProvider,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
