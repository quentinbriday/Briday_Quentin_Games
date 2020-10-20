import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Game} from '../../models/game';
import {GamesService} from '../games.service';

@Component({
  selector: 'app-games-list',
  templateUrl: './games-list.component.html',
  styleUrls: ['./games-list.component.css']
})
export class GamesListComponent implements OnInit {

  games: Observable<Game[]>;
  displayedColumns: string[] = ['name', 'category', 'difficulty', 'age', 'actions'];

  constructor(private gamesService: GamesService) { }

  ngOnInit(): void {
    this.getGames();
  }

  getGames(): void{
    this.games = this.gamesService.findAllGames();
  }

}
