export class Game {
  id;
  gameName: string;
  editor?: string;
  author?: string;
  yearEdition?: number;
  age?: string;
  minPlayers?: number;
  maxPlayers?: number;
  category?: Category;
  playDuration?: string;
  difficulty?: Difficulty;
  price?: number;
  image?: number;
}

export interface Difficulty {
  id?;
  difficultyName?: string;
}

export interface Category {
  id?;
  categoryName?: string;
}
