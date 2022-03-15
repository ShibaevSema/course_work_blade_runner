import {AfterViewInit, Component, OnInit, ViewChild} from '@angular/core';
import {MenuItem, MessageService} from 'primeng/api';
import {MainSpaceDirective} from '../directives/main-space.directive';
import {MainTableComponent} from '../main-table/main-table.component';
import {VoitKampfTestTableComponent} from '../voit-kampf-test-table/voit-kampf-test-table.component';
import {VoitKampfTestComponent} from '../voit-kampf-test/voit-kampf-test.component';
import {ExistingBladeRunnersTasksComponent} from '../existing-blade-runners-tasks/existing-blade-runners-tasks.component';
import {NewBladeRunnerTaskComponent} from '../new-blade-runner-task/new-blade-runner-task.component';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit, AfterViewInit {

  items: MenuItem[];


  @ViewChild(MainSpaceDirective, {static: true}) mainSpaceDirective!:MainSpaceDirective;

  constructor(private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.items = [
      {
        label: 'Граждане',
        items: [
          {label: 'Люди', command: ()=>this.showMainTable("Люди")},
          {label: 'Реплеканты', command: ()=>this.showMainTable("Реплеканты")},
          {label: 'Все', command: ()=>this.showMainTable("Все")},
          {label: 'Не установлено', command: ()=>this.showMainTable("Не установлено")}
        ]
      },
      {
        label: 'Тесты Войта-Кампфа',
        items: [
          {label: 'Посмотреть пройденные', command: () => this.showVoitCampfTestTable()},
          {label: 'Провести тестирование', command: () => this.showVoitCampfTest()}
        ]
      },
      {
        label: 'Бегущие по лезвию',
        items: [
          {label: 'Посмотреть текущие задания', command: () => this.showCurrentTasks()},
          {label: 'Назначить новое задание', command: () => this.showAddNewTask()}
        ]
      }
    ];
    this.showMainTable("Все");
  }

  ngAfterViewInit(): void {
    this.onSuccess("Вход выполнен успешно!");
  }

  onSuccess(message: any){
    this.messageService.add({severity: 'success', summary:'Success', detail: message, life: 2000});
  }

  onError(message: any){
    this.messageService.add({severity: 'error', summary: 'Error!', detail: message, life: 2000})
  }

  logout() {
    //TODO: route to auth page
  }

  showMainTable(header: string): void {
    const viewContainerRef = this.mainSpaceDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<MainTableComponent>(MainTableComponent);
    componentRef.instance.headerValue = header;

  }

  showVoitCampfTestTable(): void{
    const viewContainerRef = this.mainSpaceDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<VoitKampfTestTableComponent>(VoitKampfTestTableComponent);
  }

  showVoitCampfTest(): void{
    const viewContainerRef = this.mainSpaceDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<VoitKampfTestComponent>(VoitKampfTestComponent);
  }

  showCurrentTasks(): void{
    const viewContainerRef = this.mainSpaceDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<ExistingBladeRunnersTasksComponent>(ExistingBladeRunnersTasksComponent);
  }

  showAddNewTask(): void{
    const viewContainerRef = this.mainSpaceDirective.viewContainerRef;
    viewContainerRef.clear();

    const componentRef = viewContainerRef.createComponent<NewBladeRunnerTaskComponent>(NewBladeRunnerTaskComponent);
  }
}
