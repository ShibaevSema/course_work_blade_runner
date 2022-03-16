import {Component, OnInit, ViewChild} from '@angular/core';
import {ActionDirective} from "../../directives/action.directive";
import {NewActionComponent} from "../new-action/new-action.component";
import {DescendantDirective} from "../../directives/descendant.directive";
import {NewDescendantComponent} from "../new-descendant/new-descendant.component";
import {HumanoidService} from "../../services/humanoid.service";
import {Action} from "../../samples/action";

@Component({
    selector: 'app-humanoid-form',
    templateUrl: './humanoid-form.component.html',
    styleUrls: ['./humanoid-form.component.css']
})
export class HumanoidFormComponent implements OnInit {
    fullName: string;
    birthDate: Date;
    deathDate: Date;
    sex: boolean;
    isHuman: string[] = ["Человек", "Реплекант", "Неизвестно"];
    selectedHumanoidState: string;
    amountOfActions: number = 1;
    allActions: NewActionComponent[] = [];
    amountOfDescendants: number = 1;
    allDescendants: NewDescendantComponent[] = []
    existingActions: Action[]


    @ViewChild(ActionDirective, {static: true}) actionDirective!: ActionDirective;
    @ViewChild(DescendantDirective, {static: true}) descendantDirective!: DescendantDirective;

    constructor(public humanoidService: HumanoidService) {
    }

    ngOnInit(): void {
    }

    createNewAction() {
        const componentRef = this.actionDirective.viewContainerRef.createComponent<NewActionComponent>(NewActionComponent);
        this.humanoidService.getAllActions().subscribe((actions)=>this.existingActions=actions);
        componentRef.instance.id = this.amountOfActions;
        componentRef.instance.existingActions = this.existingActions;
        this.allActions.push(componentRef.instance);
        this.amountOfActions += 1;
    }

    createNewDescendant() {
        const componentRef = this.actionDirective.viewContainerRef.createComponent<NewDescendantComponent>(NewDescendantComponent);
        componentRef.instance.id = this.amountOfDescendants;
        this.allDescendants.push(componentRef.instance);
        this.amountOfDescendants += 1;
    }
}
