import { Component, OnInit } from '@angular/core';
import {Message, MessageService} from 'primeng/api';
import {NotificationsService} from 'angular2-notifications';
import {Router} from '@angular/router';
import {LoaderService} from '../services/loader.service';

interface Credentials{
  username: string;
  password: string;
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  private restrictedSymbols: string = '\"\' ;,.';

  login!: string;
  password!: string;

  msgs!: Message[];

  constructor(private messageService: MessageService,
              private router: Router,
              private loaderService: LoaderService) {

  }


  register(): void{
    let credentials : Credentials;
    credentials = {username: this.login, password: this.password}
    if(this.check()){
      (async () => {
        this.loaderService.isLoading.next(true);
        await new Promise(f => setTimeout(f, 400));
        this.loaderService.isLoading.next(false);
        this.router.navigateByUrl('/main').then(()=>console.log('Navigated to /main'));
      })();
    }else{
      this.onError("Вы ввели неверные данные. Проверьте длинну введенных логина и пароля и убедитесь, что вы не используете запрещенные символы");
    }
  }

  onSuccess(message: any){
    this.messageService.add({severity: 'success', summary:'Success', detail: message, life: 2000});
  }

  onError(message: any){
    this.messageService.add({severity: 'error', summary: 'Error!', detail: message, life: 2000})
  }

  ngOnInit(): void {
    this.msgs = [];
  }

  private check(): boolean{
    let i = 0;
    if(this.login != undefined && this.password != undefined && this.login.length>=5 && this.password.length>=5){
      for(i=0; i< this.restrictedSymbols.length; i++){
        if(this.login.indexOf(this.restrictedSymbols[i])>-1||this.password.indexOf(this.restrictedSymbols[i])>-1){
          return false;
        }
      }
      return true;
    }
    return false;
  }
}
