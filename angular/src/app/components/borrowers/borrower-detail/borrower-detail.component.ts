import { Component, OnInit } from '@angular/core';
import {Game} from '../../models/game';
import {ActivatedRoute, Router} from '@angular/router';
import {GamesService} from '../../games/games.service';
import {Borrower} from '../../models/borrower';
import {BorrowersService} from '../borrowers.service';

@Component({
  selector: 'app-borrower-detail',
  templateUrl: './borrower-detail.component.html',
  styleUrls: ['./borrower-detail.component.css']
})
export class BorrowerDetailComponent implements OnInit {

  borrower: Borrower;
  private id: string = this.route.snapshot.paramMap.get('id');

  constructor(private route: ActivatedRoute, private router: Router, private borrowersService: BorrowersService) { }

  ngOnInit(): void {
    this.borrowersService.findBorrowerById(this.id).subscribe(borrower => this.borrower = borrower);
  }

}
