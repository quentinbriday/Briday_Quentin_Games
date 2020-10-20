import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Difficulty, Game} from '../models/game';
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

  searchGames(name: string): Observable<Game[]> {
    return this.client.get<Game[]>(environment.backEndUrl + '/games/name/' + name);
  }

  searchGamesMinDifficulty(difficulty: string): Observable<Game[]> {
    return this.client.get<Game[]>(environment.backEndUrl + '/games/difficulty/greater_than_' + difficulty);
  }

  getGameDifficulties(): Observable<Difficulty[]> {
    return this.client.get<Difficulty[]>(environment.backEndUrl + '/difficulties');
  }
}
