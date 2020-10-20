import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Difficulty, Game} from '../../models/game';
import {GamesService} from '../games.service';

@Component({
  selector: 'app-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.css']
})
export class GamesListComponent implements OnInit {

  games: Observable<Game[]>;
  gameDifficulties: Difficulty[];
  displayedColumns: string[] = ['name', 'category', 'difficulty', 'age', 'actions'];

  constructor(private gamesService: GamesService) { }

  ngOnInit(): void {
    this.getGames();
    this.gamesService.getGameDifficulties().subscribe(difficulties => this.gameDifficulties = difficulties);
  }

  getGames(): void{
    this.games = this.gamesService.findAllGames();
  }

  searchGames(name: string): void {
    this.games = this.gamesService.searchGames(name);
  }

  searchGameMinDifficulty(difficulty: string): void{
    this.games = this.gamesService.searchGamesMinDifficulty(difficulty);
  }


}
