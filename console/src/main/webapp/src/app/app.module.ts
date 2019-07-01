import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutModule } from 'src/app/modules/layout/layout.module';
import { ServersModule } from 'src/app/modules/servers/servers.module';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LayoutModule,
    ServersModule,
    SweetAlert2Module.forRoot({
      buttonsStyling: false,
      customClass: 'modal-content',
      confirmButtonClass: 'btn btn-success mx-3',
      cancelButtonClass: 'btn btn-danger mx-3'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
