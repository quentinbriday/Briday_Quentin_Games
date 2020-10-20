import { BrowserModule } from '@angular/platform-browser';
import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import { GamesListComponent } from './components/games/games-list/games-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {RouterModule} from '@angular/router';
import {AppRoutes} from './app.routes';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatSlider} from '@angular/material/slider';
import {MatIconModule} from '@angular/material/icon';
import {MatOptionModule} from '@angular/material/core';
import {MatButtonModule} from '@angular/material/button';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatSelectModule} from '@angular/material/select';
import {MatTableModule} from '@angular/material/table';
import {MatCardModule} from '@angular/material/card';
import { BorrowersListComponent } from './components/borrowers/borrowers-list/borrowers-list.component';
import { HomeComponent } from './components/home/home/home.component';
import {HttpInterceptor} from './components/HttpInterceptor';
import { GameDetailComponent } from './components/games/game-detail/game-detail.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BorrowsListComponent } from './components/borrows/borrows-list/borrows-list.component';
import { BorrowerDetailComponent } from './components/borrowers/borrower-detail/borrower-detail.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    GamesListComponent,
    BorrowersListComponent,
    HomeComponent,
    GameDetailComponent,
    BorrowsListComponent,
    BorrowerDetailComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(AppRoutes),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatButtonModule,
    MatOptionModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTableModule,
    MatCardModule,
    ReactiveFormsModule,
    NgbModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: HttpInterceptor, multi: true}],
  bootstrap: [HomeComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule { }
