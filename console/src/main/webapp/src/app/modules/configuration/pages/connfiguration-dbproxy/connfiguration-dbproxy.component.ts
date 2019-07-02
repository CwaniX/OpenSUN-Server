import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { SUNServer } from 'src/app/shared/models/sun-server';
import { ServerService } from 'src/app/core/services/server.service';
import { AlertService } from 'src/app/core/services/alert.service';

@Component({
  selector: 'app-connfiguration-dbproxy',
  templateUrl: './connfiguration-dbproxy.component.html',
  styleUrls: ['./connfiguration-dbproxy.component.scss']
})
export class ConnfigurationDbproxyComponent implements OnInit {

  public serversList: Observable<SUNServer[]>;
  public selectedServer: SUNServer;

  constructor(private serverService: ServerService, private alertService: AlertService) { }

  ngOnInit() {
    this.refreshServersList();
  }

  public deleteServer(server: SUNServer) {
    this.serverService.deleteServer(server.id)
      .subscribe(
        success => {
          this.refreshServersList();
          this.selectedServer = null;
          this.alertService.info(`Serwer ${server.name} został usunięty.`);
        },
        error => this.alertService.error(`Nie udało się usunąć serwera ${server.name}`)
      );
  }

  public selectServer(server: SUNServer) {
    if (this.selectedServer && server.id === this.selectedServer.id) {
      this.selectedServer = null;
    } else {
      this.selectedServer = server;
    }
  }

  private refreshServersList() {
    this.serversList = this.serverService.getServersList();
  }
}
