import { Component, OnInit } from '@angular/core';
import {Humanoid} from '../../samples/humanoid';
import {HumanoidService} from '../../services/humanoid.service';
import {DynamicDialogRef} from 'primeng/dynamicdialog';

@Component({
  selector: 'app-select-replicant-popup',
  templateUrl: './select-replicant-popup.component.html',
  styleUrls: ['./select-replicant-popup.component.css']
})
export class SelectReplicantPopupComponent implements OnInit {

  allReplicants: Humanoid[];
  selectedReplicant: Humanoid;

  constructor(public humanoidService: HumanoidService, public ref: DynamicDialogRef) { }

  ngOnInit(): void {
    this.allReplicants=this.humanoidService.getAllHumanoids().filter((humanoid)=>!humanoid.isHuman);
  }

  selectReplicant(){
    this.ref.close(this.selectedReplicant);
  }

  onRowSelect($event: any) {
    this.selectReplicant();
  }
}
