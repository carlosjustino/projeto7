import { Component, OnInit, OnDestroy, Inject , ReflectiveInjector} from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import { User, Tarefa } from '../_models';
import { TarefaService, AuthenticationService } from '../_services';
import { Router, Navigation } from '@angular/router';
import { ConfirmationDialog } from '../_components';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  selector: 'app-tarefas',
  templateUrl: './tarefas.component.html',
  styleUrls: ['./tarefas.component.scss']

})
export class TarefasComponent implements OnInit , OnDestroy {
  currentUser: User;
  currentUserSubscription: Subscription;
  tarefas: Tarefa[] = [];
  displayedColumns: string[] = ['numero','titulo','datainclusao', 'concluida','acoes'];



  constructor(
    private authenticationService: AuthenticationService,
    private tarefaService: TarefaService,
    public dialog: MatDialog,
      private router: Router)
    {
      this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
      this.currentUser = user;
      });
    }


  ngOnInit() {
    this.loadAllTasks();
  }

  ngOnDestroy() {
    // unsubscribe to ensure no memory leaks
    this.currentUserSubscription.unsubscribe();
  }
/*
  goToDetalhesByService(tarefa: Tarefa) {
      this.tarefaService.setTarefa(tarefa);
      this.router.navigateByUrl('/tarefa')
    }
*/
    goToDetalhesByState(tarefa?: Tarefa) {
      this.router.navigateByUrl('/tarefa', {
        state: { tarefa: tarefa }
      })
    }

  openConfirmationDialog(task: Tarefa ){
    const aux = "Tem certeza que deseja deletar a Tarefa " + task.id;
    const dialogRef = this.dialog.open(ConfirmationDialog, {
      disableClose: false
      , data : {mensagem : aux}
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result) {
       this.deleteTask(task.id);
      }

    });
  }

  deleteTask(id: number) {
    this.tarefaService.delete(id).pipe(first()).subscribe(() => {
      this.loadAllTasks()
    });
  }
  formatLogico(data){
    if (data && data == true)
        return "Sim";
    else
        return "Não";
  }

  formatDate(data) {
    try{
      if (data) {
        let day= data[2],

           month=  data[1],

           year=  data[0]
          ,
          hour=  data[3]
          ,
          minute= data[4]
          ,
          second =  data[5]
          ,
          millisecond=  data[6],
        pattern= "dd/MM/yyyy HH:mm:ss";

        return pattern
          .replace("dd", day)
          .replace("MM", month)
          .replace("yyyy", year)
          .replace("HH", hour)
          .replace("mm", minute)
          .replace("ss", second)
          .replace("fff", millisecond);
}
      return data;
    } catch(e){
      console.error(e);
    }

  }

  private loadAllTasks() {
    this.tarefaService.getAll(this.currentUser.id).pipe(first()).subscribe(tasks => {
      this.tarefas = tasks;
    });
  }
}
