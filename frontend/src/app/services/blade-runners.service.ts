import {Injectable} from '@angular/core';
import {BladeRunner} from '../samples/blade-runner';
import {BladeRunnerTask} from '../samples/blade-runner-task';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Humanoid} from "../samples/humanoid";

@Injectable({
  providedIn: 'root'
})
export class BladeRunnersService {

  public bladeRunners: BladeRunner[];
  public bladeRunnersTasks: BladeRunnerTask[];

  constructor(private http: HttpClient) {

  }

  public getExistingBladeRunners(): Observable<any> {
    //TODO: запросом получить всех существующих бегущих по лезвию
    return this.http.get<BladeRunner>("api/blade_runners/get");
  }

  public getBladeRunnersTasks(): Observable<any> {
    //TODO: запросом получить все существующие задания по поиску реплекантов

    return this.http.get<BladeRunnerTask>("api/blade_runners/get/tasks");
  }

  public setBladeRunnerTask(bladeRunner: BladeRunner, humanoid: Humanoid): Observable<any>{
    return this.http.post("api/blade_runners/register/task", {entity_id: humanoid.entityId, blade_runner_id: bladeRunner.br_id});
  }

  public deleteBladeRunnerTask(bladeRunner: BladeRunner, humanoid: Humanoid): Observable<any>{
    return this.http.post("api/blade_runners/register/task", {entity_id: humanoid.entityId, blade_runner_id: bladeRunner.br_id});
  }

  public updateBladeRunnerTask(task: BladeRunnerTask): Observable<any>{
    return this.http.put("api/blade_runners/update/task", {id: task.task_id,entity_id: task.replicant.entityId, blade_runner_id: task.bladeRunner.br_id, result: task.result});
  }
}
