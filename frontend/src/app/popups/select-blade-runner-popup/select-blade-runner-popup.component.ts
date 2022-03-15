import { Component, OnInit } from '@angular/core';
import {BladeRunner} from '../../samples/blade-runner';
import {HumanoidService} from '../../services/humanoid.service';
import {DynamicDialogRef} from 'primeng/dynamicdialog';
import {BladeRunnersService} from '../../services/blade-runners.service';

@Component({
  selector: 'app-select-blade-runner-popup',
  templateUrl: './select-blade-runner-popup.component.html',
  styleUrls: ['./select-blade-runner-popup.component.css']
})
export class SelectBladeRunnerPopupComponent implements OnInit {
  allBladeRunners: BladeRunner[];
  selectedBladeRunner: BladeRunner;

  constructor(public bladeRunnersService: BladeRunnersService, public ref: DynamicDialogRef) { }

  ngOnInit(): void {
    this.allBladeRunners=this.bladeRunnersService.getExistingBladeRunners();
  }

  onRowSelect($event: any) {
    this.selectBladeRunner();
  }

  private selectBladeRunner() {
    this.ref.close(this.selectedBladeRunner);
  }
}
