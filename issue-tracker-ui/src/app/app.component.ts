import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { SelectItem } from 'primeng/api';
// import { bcrypt } from '../../../issue-tracker-ui/node_modules/bcrypt';
// tslint:disable-next-line:prefer-const
// let bcrypt = require('bcryptjs');


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

  static API_URL = 'http://localhost:8080/';
  title = 'spring boot and angular 4 secure authentication';

  boards: Board[];
  selectedBoard: Board;

  constructor() {

    this.boards = [
      { name: 'Board1', code: 'b1' },
      { name: 'Board2', code: 'b2' },
      { name: 'Board3', code: 'b3' },
      { name: 'Board4', code: 'b4' }
    ];

    // const salt = 10; // increase this if you want more iterations
    // const userPassword = 'password';
    // bcrypt.hash(userPassword, salt, function(err, hash) {
    //   console.log(hash);
    // });
    console.log('AppComponent ngOnInit');
  }

  ngOnInit(): void {
  }
}
