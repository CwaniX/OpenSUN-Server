import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SUNServer, SUNServerCategory } from 'src/app/shared/models/sun-server';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServerService {

  constructor(private http: HttpClient) { }

  /*public getServersList(): Observable<SUNServer[]> {
    //return this.http.get<SUNServer[]>('/api/secure/server').pipe();
    const servers: SUNServer[] = [
      {
        id: 0,
        ip: '127.0.0.1',
        username: 'Test 1',
        port: '4444',
        category: SUNServerCategory.DBPROXY
      },
      {
        id: 1,
        ip: '127.0.0.1',
        username: 'Test 1',
        port: '4444',
        category: SUNServerCategory.DBPROXY
      },
    ];

    return of(servers);
  }*/

  /*public deleteServer(id: number): Observable<any> {
    return this.http.delete<any>(`/api/secure/server/${id}`).pipe();
  }*/
}
