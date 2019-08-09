import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfigurationComponent } from './pages/configuration/configuration.component';
import { RouterModule } from '@angular/router';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ConnfigurationDbproxyComponent } from './pages/connfiguration-dbproxy/connfiguration-dbproxy.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [ConfigurationComponent, ConnfigurationDbproxyComponent],
  imports: [
    CommonModule,
    RouterModule,
    FormsModule,
    SweetAlert2Module
  ]
})
export class ConfigurationModule { }
