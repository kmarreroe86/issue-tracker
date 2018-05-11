import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SelectItem } from 'primeng/api';

interface Board {
  code: string;
  name: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  encapsulation: ViewEncapsulation.None // Remove angular boilerplate html code.
})

export class AppComponent implements OnInit {

  title = 'app';

  boards: Board[];
  selectedBoard: Board;

  constructor() {

    this.boards = [
      { name: 'Board1', code: 'b1' },
      { name: 'Board2', code: 'b2' },
      { name: 'Board3', code: 'b3' },
      { name: 'Board4', code: 'b4' }
    ];
  }

  ngOnInit(): void {
  }
}
