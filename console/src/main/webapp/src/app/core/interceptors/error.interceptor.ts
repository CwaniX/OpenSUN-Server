import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AlertService } from 'src/app/core/services/alert.service';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(private alertService: AlertService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            this.alertService.error(err.error.message || err.statusText);

            const error = err.error.message || err.statusText;
            return throwError(error);
        }));
    }
}
