import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlertService {
  private subject = new Subject<any>();

  info(message: string) {
    this.subject.next({ type: 'info', text: message });
  }

  error(message: string) {
    this.subject.next({ type: 'error', text: message });
  }

  getMessage(): Observable<any> {
    return this.subject.asObservable();
  }
}
