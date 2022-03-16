import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-new-descendant',
  templateUrl: './new-descendant.component.html',
  styleUrls: ['./new-descendant.component.css']
})
export class NewDescendantComponent implements OnInit {
  id: number;

  constructor() { }

  ngOnInit(): void {
  }

}
