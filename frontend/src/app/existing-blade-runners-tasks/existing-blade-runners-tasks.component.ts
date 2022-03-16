import { Component, OnInit } from '@angular/core';
import {BladeRunnersService} from '../services/blade-runners.service';
import {BladeRunnerTask} from '../samples/blade-runner-task';
import {ConfirmationService, MessageService} from 'primeng/api';
import {DialogService} from "primeng/dynamicdialog";

@Component({
  selector: 'app-existing-blade-runners-tasks',
  templateUrl: './existing-blade-runners-tasks.component.html',
  styleUrls: ['./existing-blade-runners-tasks.component.css'],
  providers: [DialogService]
})
export class ExistingBladeRunnersTasksComponent implements OnInit {

  bladeRunnerTasks: BladeRunnerTask[] = [];

  constructor(public bladeRunnerService: BladeRunnersService,
              public confirmationService: ConfirmationService,
              public messageService: MessageService) { }

  ngOnInit(): void {
    this.bladeRunnerService.getBladeRunnersTasks().subscribe((bladeRunnerTasks)=>this.bladeRunnerTasks = bladeRunnerTasks);
  }

  success(task: BladeRunnerTask) {
    this.confirmationService.confirm({
      target: event.target,
      message: 'Вы уверены что вы хотите подтвердить результат задания?',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        task.result=true;
        this.bladeRunnerService.updateBladeRunnerTask(task).subscribe({
          next: result=>{ this.onSuccess("Состояние задания успешно обновлено")},
          error: error=>{this.onError(error.message)}
        })
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
        this.bladeRunnerService.updateBladeRunnerTask(task).subscribe({
          next: result=>{ this.onSuccess("Состояние задания успешно обновлено")},
          error: error=>{this.onError(error.message)}
        })
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

  onSuccess(message: any) {
    this.messageService.add({severity: 'success', summary: 'Success', detail: message, life: 2000});
  }

  onError(message: any) {
    this.messageService.add({severity: 'error', summary: 'Error!', detail: message, life: 2000});
  }
}
