import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Game} from '../models/game';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GamesService {

  constructor(private client: HttpClient) {
  }

  findAllGames(): Observable<Game[]> {
    return this.client.get<Game[]>(environment.backEndUrl + '/games');
  }

  findGameById(id: string): Observable<Game> {
    return this.client.get<Game>(environment.backEndUrl + '/games/' + id);
  }
}