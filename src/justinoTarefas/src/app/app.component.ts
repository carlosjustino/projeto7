import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './_services';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Projeto 7 - Tarefas - Justino';
  currentUser: any;

      constructor(
          private router: Router,
          private authenticationService: AuthenticationService
      ) {
          this.authenticationService.currentUser.subscribe(x => this.currentUser = x);
      }

      logout() {
          this.authenticationService.logout();
          this.router.navigate(['/login']);
      }
}
