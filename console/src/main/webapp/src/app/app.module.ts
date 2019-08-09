import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LayoutModule } from 'src/app/modules/layout/layout.module';
import { ServersModule } from 'src/app/modules/servers/servers.module';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ConfigurationModule } from 'src/app/modules/configuration/configuration.module';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { ErrorInterceptor } from 'src/app/core/interceptors/error.interceptor';
import { CoreModule } from 'src/app/core/core.module';
import { DatabaseModule } from './modules/database/database.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    LayoutModule,
    ServersModule,
    DatabaseModule,
    ConfigurationModule,
    CoreModule,
    FormsModule,
    SweetAlert2Module.forRoot({
      buttonsStyling: false,
      customClass: 'modal-content',
      confirmButtonClass: 'btn btn-success mx-3',
      cancelButtonClass: 'btn btn-danger mx-3'
    })
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
