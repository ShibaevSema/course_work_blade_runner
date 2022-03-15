import { Component, OnInit } from '@angular/core';
import {Profession} from '../../samples/profession';
import {DialogService, DynamicDialogConfig} from 'primeng/dynamicdialog';
import {ProfessionService} from '../../services/profession.service';
import {Humanoid} from '../../samples/humanoid';
import {HumanoidService} from '../../services/humanoid.service';
import {VoitKampfTestResult} from '../../samples/voit-kampf-test-result';
import {VoitKampfTestService} from '../../services/voit-kampf-test.service';
import {ReplicantData} from '../../samples/replicant-data';

@Component({
  selector: 'app-main-table-popup',
  templateUrl: './main-table-popup.component.html',
  styleUrls: ['./main-table-popup.component.css']
})
export class MainTablePopupComponent implements OnInit {
  id: number;
  humanoid: Humanoid;
  profession: Profession;
  descendants: Humanoid[];
  voitKampfTests: VoitKampfTestResult[];
  replicantModel: ReplicantData;

  constructor(public config: DynamicDialogConfig,
              public professionService: ProfessionService,
              public humanodService: HumanoidService,
              public voitKampfTestService: VoitKampfTestService){ }

  ngOnInit(): void {
    this.id = this.config.data.humanoid.id;
    this.humanoid = this.config.data.humanoid;
    if(!this.humanoid.isHuman){
      this.replicantModel = this.humanodService.getReplicantModel(this.humanoid.id);
    }
    this.profession = this.professionService.getProfession(this.config.data.humanoid.id);
    this.descendants = this.humanodService.getDescendants();
    this.voitKampfTests = this.voitKampfTestService.getVoitKampfTests(this.humanoid.id);
  }


}
