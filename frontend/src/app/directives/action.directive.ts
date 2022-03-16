import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[actionPos]'
})
export class ActionDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
