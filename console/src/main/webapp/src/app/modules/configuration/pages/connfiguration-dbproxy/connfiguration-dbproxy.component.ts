import { Component, OnInit } from '@angular/core';
import { SUNServer } from 'src/app/shared/models/sun-server';
import { ServerService } from 'src/app/core/services/server.service';
import { AlertService } from 'src/app/core/services/alert.service';

@Component({
  selector: 'app-connfiguration-dbproxy',
  templateUrl: './connfiguration-dbproxy.component.html',
  styleUrls: ['./connfiguration-dbproxy.component.scss']
})
export class ConnfigurationDbproxyComponent implements OnInit {

  public currentServer: SUNServer = new SUNServer();

  constructor(private serverService: ServerService, private alertService: AlertService) { }

  ngOnInit() {

  }

  saveServer() {
    console.log(`Saving server with name: ${this.currentServer.username}`);
  }
}
