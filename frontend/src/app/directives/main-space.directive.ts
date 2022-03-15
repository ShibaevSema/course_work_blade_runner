import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[mainSpace]'
})
export class MainSpaceDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
