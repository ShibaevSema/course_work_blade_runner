import { Component, OnInit } from '@angular/core';
import {BladeRunnersService} from '../services/blade-runners.service';
import {BladeRunnerTask} from '../samples/blade-runner-task';
import {ConfirmationService} from 'primeng/api';

@Component({
  selector: 'app-existing-blade-runners-tasks',
  templateUrl: './existing-blade-runners-tasks.component.html',
  styleUrls: ['./existing-blade-runners-tasks.component.css']
})
export class ExistingBladeRunnersTasksComponent implements OnInit {

  bladeRunnerTasks: BladeRunnerTask[];

  constructor(public bladeRunnerService: BladeRunnersService,
              public confirmationService: ConfirmationService) { }

  ngOnInit(): void {
    this.bladeRunnerTasks = this.bladeRunnerService.getBladeRunnersTasks();
    console.log(this.bladeRunnerTasks.length);
  }

  success(task: BladeRunnerTask) {
    this.confirmationService.confirm({
      target: event.target,
      message: 'Вы уверены что вы хотите подтвердить результат задания?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        task.result=true;
      },
      reject: () => {
        //reject action
      }
    });
  }

  fail(task: BladeRunnerTask){
    this.confirmationService.confirm({
      target: event.target,
      message: 'Вы уверены что вы хотите подтвердить результат задания?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        task.result=false;
      },
      reject: () => {
        //reject action
      }
    });
  }

  delete(task: BladeRunnerTask) {
    this.confirmationService.confirm({
      target: event.target,
      message: 'Вы уверены что вы хотите удалить результат задания?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.bladeRunnerTasks.splice(this.bladeRunnerTasks.findIndex(t=>t===task).valueOf(),1);
      },
      reject: () => {
        //reject action
      }
    });
  }
}
