import {Game} from './game';
import {Borrower} from './borrower';

export class Borrows {
  id;
  game: Game;
  borrower: Borrower;
  borrowDate: Date;
  returnDate?: Date;
}
