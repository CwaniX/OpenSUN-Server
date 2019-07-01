import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServersComponent } from 'src/app/modules/servers/pages/servers/servers.component';
import { ServersListComponent } from 'src/app/modules/servers/pages/servers-list/servers-list.component';

const routes: Routes = [
  {
    path: 'servers', component: ServersComponent, children: [
      {
        path: '',
        component: ServersListComponent,
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
