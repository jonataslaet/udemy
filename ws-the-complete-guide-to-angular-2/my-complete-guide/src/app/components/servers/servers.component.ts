import { Component } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent {
  serverStatus = 'No server was created';

  allowAddNewServer: boolean = false;

  constructor() {
    setTimeout(() => {
      this.allowAddNewServer = true;
    }, 2000);
  }

  onCreatedServer() {
    this.serverStatus = 'A server was created';
  }
}
