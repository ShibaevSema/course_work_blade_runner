import {Component, Input, OnInit} from '@angular/core';
import {Humanoid} from '../samples/humanoid';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {MainTablePopupComponent} from '../popups/main-table-popup/main-table-popup.component';
import {MessageService} from 'primeng/api';
import {HumanoidService} from '../services/humanoid.service';
import {HumanoidFormComponent} from '../forms/humanoid-form/humanoid-form.component';

@Component({
  selector: 'app-main-table',
  templateUrl: './main-table.component.html',
  styleUrls: ['./main-table.component.css'],
  providers: [DynamicDialogRef, DialogService]
})
export class MainTableComponent implements OnInit {

  @Input("headerValue") headerValue: string;

  selectedCut: Humanoid[];
  allHumanoids: Humanoid[];
  cols: any[];
  selectedHumanoid: Humanoid;

  constructor(public messageService: MessageService,
              public ref: DynamicDialogRef,
              public dialogService: DialogService,
              public humanoidService: HumanoidService) {
  }

  ngOnInit(): void {


    this.cols = [
      { field: 'fullName', header: 'Полное имя' },
      { field: 'sex', header: 'Пол' },
      { field: 'birthDate', header: 'Дата рождения' },
      { field: 'deathDate', header: 'Дата смерти' },
      { field: 'location', header: 'Местоположение' }
    ];
    this.allHumanoids=this.humanoidService.getAllHumanoids();
    this.onSelectCutChange();

  }

  onRowSelect(event) {
    this.ref = this.dialogService.open(MainTablePopupComponent, {
      data: {
        humanoid: this.selectedHumanoid
      },
      header: "[id:"+this.selectedHumanoid.id+"] "+this.selectedHumanoid.fullName,
      width: '80%',
      dismissableMask: true,
      contentStyle: {"max-height": "800px", "overflow": "auto"},
      baseZIndex: 10000,
      showHeader: true
    });
  }


  ngOnDestroy(): void {
    if(this.ref){
      this.ref.close();
    }
  }

  onSuccess(message: any){
    this.messageService.add({severity: 'success', summary:'Success', detail: message, life: 2000});
  }

  onError(message: any){
    this.messageService.add({severity: 'error', summary: 'Error!', detail: message, life: 2000})
  }

  public onSelectCutChange(): void{
    switch (this.headerValue){
      case 'Все':
        this.selectedCut=this.allHumanoids;
        break;
      case 'Люди':
        this.selectedCut=this.allHumanoids.filter((humanoid)=>{return humanoid.isHuman});
        break;
      case 'Реплеканты':
        this.selectedCut=this.allHumanoids.filter((humanoid)=>{return !humanoid.isHuman && humanoid.isHuman!=null});
        break;
      case 'Не установлено':
        this.selectedCut=this.allHumanoids.filter((humanoid)=>{return humanoid.isHuman==null});
        break;
      default:
        this.selectedCut=this.allHumanoids;
        break;
    }
  }

  createNewPerson() {
    this.ref = this.dialogService.open(HumanoidFormComponent, {
      header: "Добавить нового гуманойда",
      width: '80%',
      dismissableMask: true,
      contentStyle: {"min-height": "1000px", "overflow": "auto"},
      baseZIndex: 10000,
      showHeader: true
    });
  }
}
