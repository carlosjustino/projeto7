import { Component, OnInit, OnDestroy, Inject , ReflectiveInjector} from '@angular/core';
import { Subscription } from 'rxjs';
import { first } from 'rxjs/operators';
import { User, Tarefa } from '../_models';
import { TarefaService, AuthenticationService, AlertService } from '../_services';
import { Router, Navigation } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-tarefa',
  templateUrl: './tarefa.component.html',
  styleUrls: ['./tarefa.component.scss']

})
export class TarefaComponent implements OnInit {
  currentUser: User;
  currentUserSubscription: Subscription;
  tarefa: Tarefa;
  registerForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private tarefaService: TarefaService,
            private alertService: AlertService,
    private router: Router)
    {
    const nav = this.router.getCurrentNavigation();
    this.tarefa = nav.extras.state.tarefa;
      this.currentUserSubscription = this.authenticationService.currentUser.subscribe(user => {
      this.currentUser = user;
      });
    }


  ngOnInit() {
    if (!this.tarefa) // Não existe com a abordagem do status, recupoera do service
       {
      //   this.tarefa = this.tarefaService.getTarefa()
          this.tarefa = new Tarefa();
       }

       this.registerForm = this.formBuilder.group({
                   titulo: [this.tarefa.titulo, Validators.required],
                   descricao: [this.tarefa.descricao, Validators.required],
                   concluida: [this.tarefa.concluida]
               });
  }
   get f() { return this.registerForm.controls; }


  onSubmit() {
        this.submitted = true;

        // reset alerts on submit
        this.alertService.clear();

        // stop here if form is invalid
        if (this.registerForm.invalid) {
            return;
        }

        this.loading = true;
        if (this.tarefa.id != undefined && this.tarefa.id > 0){
            this.tarefa.titulo = this.registerForm.value.titulo;
            this.tarefa.descricao = this.registerForm.value.descricao;
            this.tarefa.concluida = this.registerForm.value.concluida;
            this.tarefaService.update(this.tarefa)
            .pipe(first())
                        .subscribe(
                            data => {
                                this.alertService.success('Tarefa alterada com sucesso', true);
                                this.router.navigate(['/']);
                            },
                            error => {
                                this.alertService.error(error);
                                this.loading = false;
                            });
        } else {
            this.tarefa = new Tarefa();
            this.tarefa.titulo = this.registerForm.value.titulo;
            this.tarefa.descricao = this.registerForm.value.descricao;
            this.tarefa.concluida = this.registerForm.value.concluida;
            this.tarefaService.nova(this.tarefa, this.currentUser.id)
            .pipe(first())
                        .subscribe(
                            data => {
                                this.alertService.success('Tarefa cadastrada com sucesso', true);
                                this.router.navigate(['/']);
                            },
                            error => {
                                this.alertService.error(error);
                                this.loading = false;
                            });
        }

    }


/*
  deleteTask(id: number) {
    this.tarefaService.delete(id).pipe(first()).subscribe(() => {
      this.loadAllTasks()
    });
  }*/


}
