import {Component, OnInit} from '@angular/core';
import {LoaderService} from './services/loader.service';
import {ConfirmationService, PrimeNGConfig} from 'primeng/api';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ConfirmationService]
})
export class AppComponent implements OnInit{
  title = 'ISDBkursach';

  constructor(public loaderService: LoaderService,
              private primeNGConfig: PrimeNGConfig) {
  }

  ngOnInit(): void {
  }
}
