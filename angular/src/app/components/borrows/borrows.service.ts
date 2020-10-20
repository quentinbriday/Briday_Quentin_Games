import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Game} from '../models/game';
import {environment} from '../../../environments/environment';
import {Borrows} from '../models/borrows';

@Injectable({
  providedIn: 'root'
})
export class BorrowsService {

  constructor(private client: HttpClient) {
  }

  findAllBorrows(): Observable<Borrows[]> {
    return this.client.get<Borrows[]>(environment.backEndUrl + '/borrows');
  }
}
