import { Component, OnInit, OnDestroy, Inject , ReflectiveInjector} from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import { User, Tarefa } from '../_models';
import { TarefaService, AuthenticationService } from '../_services';
import { Router, Navigation } from '@angular/router';


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

  deleteTask(id: number) {
    this.tarefaService.delete(id).pipe(first()).subscribe(() => {
      this.loadAllTasks()
    });
  }

  private loadAllTasks() {
    this.tarefaService.getAll(this.currentUser.id).pipe(first()).subscribe(tasks => {
      this.tarefas = tasks;
    });
  }
}
