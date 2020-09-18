import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../_models';

import { environment } from '../../environments/environment';

@Injectable({ providedIn: 'root' })
export class UserService {
    constructor(private http: HttpClient) { }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/usuario/all`);
    }

    getById(id: number) {
        return this.http.get(`${environment.apiUrl}/usuario/${id}`);
    }

    register(user: User) {
        return this.http.post(`${environment.apiUrl}/usuario/create`, user);
    }

    /*update(user: User) {
        return this.http.put(`${config.apiUrl}/usuario/${user.id}`, user);
    }

    delete(id: number) {
        return this.http.delete(`${config.apiUrl}/usuario/${id}`);
    }*/
}
