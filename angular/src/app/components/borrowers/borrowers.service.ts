import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Game} from '../models/game';
import {environment} from '../../../environments/environment';
import {Borrower} from '../models/borrower';

@Injectable({
  providedIn: 'root'
})
export class BorrowersService {

  constructor(private client: HttpClient) {
  }

  findAllBorrowers(): Observable<Borrower[]> {
    return this.client.get<Borrower[]>(environment.backEndUrl + '/borrowers');
  }

  findBorrowerById(id: string): Observable<Borrower> {
    return this.client.get<Borrower>(environment.backEndUrl + '/borrowers/' + id);
  }

  searchBorrowers(name: string): Observable<Borrower[]> {
    return this.client.get<Borrower[]>(environment.backEndUrl + '/borrowers/name/' + name);
  }
}
