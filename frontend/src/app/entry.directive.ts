import { Directive, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[entry]'
})
export class EntryDirective {

  constructor(public viewContainerRef: ViewContainerRef) { }

}
