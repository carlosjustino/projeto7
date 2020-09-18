import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TarefasComponent } from './tarefas';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';


const routes: Routes = [
 { path: '', component: TarefasComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
     { path: '**', redirectTo: '' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
