import { Component, OnInit } from '@angular/core';
import {VoitKampfTestResult} from '../samples/voit-kampf-test-result';
import {VoitKampfTestTablePopupComponent} from '../popups/voit-kampf-test-table-popup/voit-kampf-test-table-popup.component';
import {MessageService} from 'primeng/api';
import {DialogService, DynamicDialogRef} from 'primeng/dynamicdialog';
import {VoitKampfTestService} from '../services/voit-kampf-test.service';

@Component({
  selector: 'app-voit-kampf-test-table',
  templateUrl: './voit-kampf-test-table.component.html',
  styleUrls: ['./voit-kampf-test-table.component.css'],
  providers: [MessageService, DialogService, DynamicDialogRef]
})
export class VoitKampfTestTableComponent implements OnInit {

  headerValue: string;
  voitKampfTests: VoitKampfTestResult[];
  selectedTest: VoitKampfTestResult;
  cols: any;

  constructor(public messageService: MessageService,
              public ref: DynamicDialogRef,
              public dialogService: DialogService,
              public voitKampfTestsService: VoitKampfTestService) { }

  ngOnInit(): void {
    this.headerValue = "Пройденные тесты Войта-Кампфа";
    this.cols = [
      {field: 'completionDate', header: 'Дата выполнения'},
      {field: 'brainReaction', header: 'Реакция мозга'},
      {field: 'eyeMovement', header: 'Движение глаз'},
      {field: 'result', header: 'Результат'}
    ];
    this.voitKampfTests = this.voitKampfTestsService.getAllVoitKampfTests();
  }

  onRowSelect($event: any) {
    this.ref = this.dialogService.open(VoitKampfTestTablePopupComponent, {
      data: {
        test: this.selectedTest
      },
      header: "Тест под номером "+this.selectedTest.id+"",
      width: '80%',
      dismissableMask: true,
      contentStyle: {"max-height": "800px", "overflow": "auto"},
      baseZIndex: 10000,
      showHeader: true
    });
  }
}
