import { Component, OnInit } from '@angular/core';
import {DynamicDialogConfig} from 'primeng/dynamicdialog';
import {VoitKampfQuestionService} from '../../services/voit-kampf-question.service';
import {VoitKampfQuestion} from '../../samples/voit-kampf-question';

@Component({
  selector: 'app-voit-kampf-test-table-popup',
  templateUrl: './voit-kampf-test-table-popup.component.html',
  styleUrls: ['./voit-kampf-test-table-popup.component.css']
})
export class VoitKampfTestTablePopupComponent implements OnInit {

  questions: VoitKampfQuestion[];

  constructor(public config: DynamicDialogConfig,
              public questionService: VoitKampfQuestionService) { }

  ngOnInit(): void {
    this.questions=this.questionService.getVoitKampfQuestions();
  }

}
