import {Injectable} from '@angular/core';
import {BladeRunner} from '../samples/blade-runner';
import {BladeRunnerTask} from '../samples/blade-runner-task';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class BladeRunnersService {

  public bladeRunners: BladeRunner[];
  public bladeRunnersTasks: BladeRunnerTask[];

  constructor(private http: HttpClient) {

  }

  public getExistingBladeRunners() {
    //TODO: запросом получить всех существующих бегущих по лезвию
    this.http.get("api/main")
    return this.bladeRunners;
  }

  public getBladeRunnersTasks() {
    //TODO: запросом получить все существующие задания по поиску реплекантов
    this.bladeRunners = [{
      id: 1, humanoid: {
        entityId: 1,
        fullName: 'Nikita Kolesnikov',
        sex: 'Male',
        birthDate: '20.11.2001',
        deathDate: '20.11.2022',
        location: '[31.12;31.16]',
        isHuman: false
      }, hq: {
        id: 1, location: '["Earth", 19.12, 25.16]', description: 'Штаб Бегущих по лезвию в Жопе мира'
      }, position: 'Капитан', position_description: 'Капитан южных морей и полярного края', available: true
    }, {
      id: 2, humanoid: {
        entityId: 2,
        fullName: 'Semen Shibaev',
        sex: 'Male',
        birthDate: '20.11.2001',
        deathDate: '20.11.2022',
        location: '[31.12;31.16]',
        isHuman: false
      }, hq: {id: 1, location: '["Earth", 19.12, 25.16]', description: 'Штаб Бегущих по лезвию в Жопе мира'},
      position: 'Капитан', position_description: 'Капитан южных морей и полярного края', available: false
    }, {
      id: 3, humanoid: {
        entityId: 6,
        fullName: 'Stepan Stepanovich',
        sex: 'Male',
        birthDate: '20.11.2001',
        deathDate: '20.11.2022',
        location: '[31.12;31.16]',
        isHuman: false
      }, hq: {id: 1, location: '["Earth", 19.12, 25.16]', description: 'Штаб Бегущих по лезвию в Жопе мира'},
      position: 'Капитан', position_description: 'Капитан южных морей и полярного края', available: false
    }];
    this.bladeRunnersTasks = [{
      id: 1, bladeRunner: this.bladeRunners[1], replicant: {
        entityId: 6,
        fullName: 'Stepan Stepanovich',
        sex: 'Male',
        birthDate: '20.11.2001',
        deathDate: '20.11.2022',
        location: '[31.12;31.16]',
        isHuman: false
      }, result: null
    }, {
      id: 2, bladeRunner: this.bladeRunners[2], replicant: {
        entityId: 1,
        fullName: 'Nikita Kolesnikov',
        sex: 'Male',
        birthDate: '20.11.2001',
        deathDate: '20.11.2022',
        location: '[31.12;31.16]',
        isHuman: false
      }, result: false
    }];
    return this.bladeRunnersTasks;
  }
}
