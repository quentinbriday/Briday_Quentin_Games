import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Borrower} from '../../models/borrower';
import {BorrowersService} from '../borrowers.service';

@Component({
  selector: 'app-borrowers-list',
  templateUrl: './borrowers-list.component.html',
  styleUrls: ['./borrowers-list.component.css']
})
export class BorrowersListComponent implements OnInit {

  borrowers: Observable<Borrower[]>;
  displayedColumns: string[] = ['name', 'telephone', 'email', 'actions'];

  constructor(private borrowersService: BorrowersService) { }

  ngOnInit(): void {
    this.getBorrowers();
    console.log(this.borrowers);
  }

  getBorrowers(): void{
    this.borrowers = this.borrowersService.findAllBorrowers();
  }

  searchBorrowers(name: string): void {
    this.borrowers = this.borrowersService.searchBorrowers(name);
  }
}
