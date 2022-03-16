import {Directive, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[descendant]'
})
export class DescendantDirective {

  constructor(viewContainerRef: ViewContainerRef) { }

}
