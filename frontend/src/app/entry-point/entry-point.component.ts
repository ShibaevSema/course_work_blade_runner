import {Component, OnInit, ViewChild} from '@angular/core';
import {MenuItem} from 'primeng/api';
import {LoginComponent} from '../login/login.component';
import {EntryDirective} from '../entry.directive';
import {RegisterComponent} from '../register/register.component';

@Component({
  selector: 'app-entry-point',
  templateUrl: './entry-point.component.html',
  styleUrls: ['./entry-point.component.css']
})
export class EntryPointComponent implements OnInit {
  items: MenuItem[];
  activeItem: MenuItem;
  text: string;

  @ViewChild(EntryDirective, {static: true}) entryDirective!:EntryDirective;


  constructor() { }

  ngOnInit(): void {
      this.items = [
        {label: 'Вход', command: event => this.showEntry()},
        {label: 'Регистрация', command: event => this.showRegistry()}
      ];
      this.activeItem = this.items[0];
      this.showEntry();
  }

  showEntry(): void {
    const viewContainerRef = this.entryDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<LoginComponent>(LoginComponent);

  }

  showRegistry(): void{
    const viewContainerRef = this.entryDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<RegisterComponent>(RegisterComponent);
  }

}
