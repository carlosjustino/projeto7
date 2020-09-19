import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { Tarefa } from '../_models';

import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class TarefaService {
    private tarefa: Tarefa;

    constructor(private http: HttpClient) { }

    getTarefa(){
      return this.tarefa;
    }

    setTarefa(tarefa: Tarefa){
        this.tarefa = tarefa;
    }

    getAll(userid: number) {
        return this.http.get<Tarefa[]>(`${environment.apiUrl}/tarefa/${userid}/all`);
    }

    getById(id: number, userid: number) {
        return this.http.get(`${environment.apiUrl}/tarefa/${userid}/${id}`);
    }

    nova(tarefa: Tarefa, userid: number) {
        return this.http.post(`${environment.apiUrl}/tarefa/${userid}/create`, tarefa);
    }

    update(tarefa: Tarefa) {
        return this.http.put(`${environment.apiUrl}/tarefa/${tarefa.id}`, tarefa);
    }

    delete(id: number) {
        return this.http.delete(`${environment.apiUrl}/tarefa/${id}`);
    }
}
