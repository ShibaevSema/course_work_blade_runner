import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {TabMenuModule} from 'primeng/tabmenu';
import { AppComponent } from './app.component';
import {PanelModule} from 'primeng/panel';
import {InputTextModule} from 'primeng/inputtext';
import {SimpleNotificationsModule} from 'angular2-notifications';
import {AppRoutingModule} from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClient} from '@angular/common/http';
import { EntryPointComponent } from './entry-point/entry-point.component';
import {FormsModule} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { EntryDirective } from './entry.directive';
import { RegisterComponent } from './register/register.component';
import {ButtonModule} from 'primeng/button';
import { MainComponent } from './main/main.component';
import {ProgressSpinnerModule} from 'primeng/progressspinner';
import {InterceptorService} from './services/interceptor.service';
import {CommonModule} from '@angular/common';
import {ToastModule} from 'primeng/toast';
import {MessageService} from 'primeng/api';
import {MenubarModule} from 'primeng/menubar';
import { MainSpaceDirective } from './directives/main-space.directive';
import { VoitKampfTestTableComponent } from './voit-kampf-test-table/voit-kampf-test-table.component';
import { VoitKampfTestComponent } from './voit-kampf-test/voit-kampf-test.component';
import {TableModule} from 'primeng/table';
import {DynamicDialogModule} from 'primeng/dynamicdialog';
import {MainTablePopupComponent} from './popups/main-table-popup/main-table-popup.component';
import {MainTableComponent} from './main-table/main-table.component';
import {TabViewModule} from 'primeng/tabview';
import {DividerModule} from 'primeng/divider';
import { VoitKampfTestTablePopupComponent } from './popups/voit-kampf-test-table-popup/voit-kampf-test-table-popup.component';
import {AccordionModule} from 'primeng/accordion';
import { ExistingBladeRunnersTasksComponent } from './existing-blade-runners-tasks/existing-blade-runners-tasks.component';
import { NewBladeRunnerTaskComponent } from './new-blade-runner-task/new-blade-runner-task.component';
import {CardModule} from 'primeng/card';
import {TooltipModule} from 'primeng/tooltip';
import { SelectReplicantPopupComponent } from './popups/select-replicant-popup/select-replicant-popup.component';
import { SelectBladeRunnerPopupComponent } from './popups/select-blade-runner-popup/select-blade-runner-popup.component';
import {ConfirmPopupModule} from 'primeng/confirmpopup';
import { HumanoidFormComponent } from './forms/humanoid-form/humanoid-form.component';
import {CalendarModule} from 'primeng/calendar';
import {CheckboxModule} from 'primeng/checkbox';
import {DropdownModule} from 'primeng/dropdown';

@NgModule({
  declarations: [
    AppComponent,
    EntryPointComponent,
    LoginComponent,
    EntryDirective,
    RegisterComponent,
    LoginComponent,
    MainComponent,
    MainSpaceDirective,
    VoitKampfTestTableComponent,
    VoitKampfTestComponent,
    MainTablePopupComponent,
    MainTableComponent,
    VoitKampfTestTablePopupComponent,
    ExistingBladeRunnersTasksComponent,
    NewBladeRunnerTaskComponent,
    SelectReplicantPopupComponent,
    SelectBladeRunnerPopupComponent,
    HumanoidFormComponent
  ],
  imports: [
    CalendarModule,
    CheckboxModule,
    DropdownModule,
    BrowserModule,
    PanelModule,
    AppRoutingModule,
    SimpleNotificationsModule.forRoot(),
    InputTextModule,
    TabMenuModule,
    TabViewModule,
    FormsModule,
    ButtonModule,
    ProgressSpinnerModule,
    CommonModule,
    ToastModule,
    MenubarModule,
    TableModule,
    DynamicDialogModule,
    DividerModule,
    AccordionModule,
    CardModule,
    TooltipModule,
    ConfirmPopupModule
  ],
  providers: [
    HttpClient,
    {provide: HTTP_INTERCEPTORS, useClass: InterceptorService, multi: true},
    MessageService
  ],
  bootstrap: [AppComponent],
  entryComponents:[
    MainTableComponent
  ]
})
export class AppModule { }
