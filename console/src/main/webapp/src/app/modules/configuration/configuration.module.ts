import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfigurationComponent } from './pages/configuration/configuration.component';
import { RouterModule } from '@angular/router';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ServerInputComponent } from './components/server-input/server-input.component';
import { ConnfigurationDbproxyComponent } from './pages/connfiguration-dbproxy/connfiguration-dbproxy.component';

@NgModule({
  declarations: [ConfigurationComponent, ServerInputComponent, ConnfigurationDbproxyComponent],
  imports: [
    CommonModule,
    RouterModule,
    SweetAlert2Module
  ]
})
export class ConfigurationModule { }
