import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EntryPointComponent} from './entry-point/entry-point.component';
import {MainComponent} from './main/main.component';

const routes: Routes = [
  {path:'main', component: MainComponent},
  {path: '**', redirectTo: 'entry'},
  { path: 'entry', component: EntryPointComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
