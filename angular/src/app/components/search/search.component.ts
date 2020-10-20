import {Component, OnInit, Output, EventEmitter} from '@angular/core';
import {Subject} from 'rxjs';
import {debounceTime, distinctUntilChanged, filter} from 'rxjs/operators';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  search$ = new Subject<string>();
  @Output() searched = new EventEmitter<string>();

  constructor() {}

  ngOnInit(): void {
    this.search$.pipe(debounceTime(400), filter(x => x.length > 2), distinctUntilChanged()).subscribe(x => this.searched.next(x));
  }

}
