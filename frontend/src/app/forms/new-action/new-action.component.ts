import {Component, OnInit} from '@angular/core';
import {Action} from "../../samples/action";
import {HumanoidService} from "../../services/humanoid.service";

@Component({
    selector: 'app-new-action',
    templateUrl: './new-action.component.html',
    styleUrls: ['./new-action.component.css']
})
export class NewActionComponent implements OnInit {
    id: number;
    existingActions: Action[]=[];
    selectedAction: Action;

    constructor(public humanoidService: HumanoidService) {
    }

    ngOnInit(): void {
    }




}
