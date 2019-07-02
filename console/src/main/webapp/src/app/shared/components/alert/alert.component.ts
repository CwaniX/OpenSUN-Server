import { Component, OnInit, OnDestroy, ViewChild } from '@angular/core';
import { Subscription } from 'rxjs';
import { SwalComponent } from '@sweetalert2/ngx-sweetalert2';
import { AlertService } from 'src/app/core/services/alert.service';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  @ViewChild('alertSwal')
  public alertSwal: SwalComponent;

  constructor(private alertService: AlertService) { }

  ngOnInit() {
    this.subscription = this.alertService.getMessage().subscribe(message => {
      this.alertSwal.title = message.text;
      this.alertSwal.type = message.type;
      setTimeout(() => this.alertSwal.show(), 200);
    });
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }
}
