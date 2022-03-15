import { Component, OnInit } from '@angular/core';
import {Message, MessageService} from 'primeng/api';

import {Router} from '@angular/router';
import {LoaderService} from '../services/loader.service';
import {ToastModule} from 'primeng/toast';

interface Credentials{
  username: string;
  password: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  private restrictedSymbols: string = '\"\' ;,.';

  login!: string;
  password!: string;

  msgs!: Message[];

  constructor(private messageService: MessageService,
              private router: Router,
              private loaderService: LoaderService) {

  }

  enter():void{
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
    return true;
  }

}
