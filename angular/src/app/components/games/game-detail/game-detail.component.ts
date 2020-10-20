import {Component, Input, OnInit, Output} from '@angular/core';
import {Game} from '../../models/game';
import {ActivatedRoute, Router} from '@angular/router';
import {GamesService} from '../games.service';

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.component.html',
  styleUrls: ['./game-detail.component.css']
})
export class GameDetailComponent implements OnInit {

  game: Game;
  private id: string = this.route.snapshot.paramMap.get('id');

  constructor(private route: ActivatedRoute, private router: Router, private gamesService: GamesService) { }

  ngOnInit(): void {
    this.gamesService.findGameById(this.id).subscribe(game => this.game = game);
  }

}
