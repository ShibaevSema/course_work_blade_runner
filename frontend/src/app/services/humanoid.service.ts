import { Injectable } from '@angular/core';
import {Humanoid} from '../samples/humanoid';
import {ReplicantData} from '../samples/replicant-data';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HumanoidService {

  public allHumanoids: Humanoid[];
  public descendants: Humanoid[];

  constructor(private http: HttpClient) { }

  getAllHumanoids(): Observable<any>{
    return this.http.get<Humanoid[]>("api/main/get/all_entities");
  }

  getDescendants(entityId: number): Observable<any>{
    const body = {id: entityId};
    return this.http.post("api/main/post/relatives", body);
  }

  getReplicantModel(id: number): ReplicantData{
    //TODO: запросом доставать модель реплеканта по id гуманойда
    return {id: 1, corporationName: "Штаб бегущих по лезвию в жопе мира", description: "Любит долбить себя в очелло", name: "Nexus-9"}
  }
}
