import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-humanoid-form',
  templateUrl: './humanoid-form.component.html',
  styleUrls: ['./humanoid-form.component.css']
})
export class HumanoidFormComponent implements OnInit {
  fullName: string;
  birthDate: Date;
  deathDate: Date;
  sex: boolean;
  isHuman: string[] = ["Человек", "Реплекант", "Неизвестно"];
  selectedHumanoidState: string;

  constructor() { }

  ngOnInit(): void {
  }

}
