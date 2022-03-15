import { Injectable } from '@angular/core';
import {VoitKampfTestResult} from '../samples/voit-kampf-test-result';

@Injectable({
  providedIn: 'root'
})
export class VoitKampfTestService {
  voitCampfTests: VoitKampfTestResult[];

  constructor() { }

  getAllVoitKampfTests(): VoitKampfTestResult[]{
    //TODO: запросом доставать все пройденные тесты
    this.voitCampfTests = [{
      id: 1, brainReaction: true, eyeMovement: false, result: false, completionDate: '09.02.2022'
    },{
      id: 2, brainReaction: true, eyeMovement: true, result: true, completionDate: '07.02.2022'
    },{
      id: 3, brainReaction: false, eyeMovement: true, result: false, completionDate: '08.02.2022'
    }];
    return this.voitCampfTests;
  }

  getVoitKampfTests(id: number): VoitKampfTestResult[]{
    //TODO: Запросом достать все пройденные тесты репликантом по индексу id
    this.voitCampfTests = [{
      id: 1, brainReaction: true, eyeMovement: false, result: false, completionDate: '09.02.2022'
    },{
      id: 2, brainReaction: true, eyeMovement: true, result: true, completionDate: '07.02.2022'
    },{
      id: 3, brainReaction: false, eyeMovement: true, result: false, completionDate: '08.02.2022'
    }];
    return this.voitCampfTests;
  }
}
