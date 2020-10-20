import { Routes} from '@angular/router';
import {AppComponent} from './app.component';
import {GamesListComponent} from './components/games/games-list/games-list.component';
import {HomeComponent} from './components/home/home/home.component';
import {BorrowersListComponent} from './components/borrowers/borrowers-list/borrowers-list.component';
import {GameDetailComponent} from './components/games/game-detail/game-detail.component';

export const AppRoutes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'games', component: GamesListComponent},
  { path: 'games/:id', component: GameDetailComponent},
  { path: 'borrowers', component: BorrowersListComponent},
];
