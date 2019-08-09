import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ServersComponent } from './pages/servers/servers.component';
import { RouterModule } from '@angular/router';
import { ServersListComponent } from './pages/servers-list/servers-list.component';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@NgModule({
  declarations: [
    ServersComponent,
    ServersListComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    SweetAlert2Module
  ]
})
export class ServersModule { }
