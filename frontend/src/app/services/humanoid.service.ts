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
    //TODO: запросом доставать всех гуманойдов
    // this.allHumanoids=[{
    //   id: 1, fullName:"Nikita Kolesnikov", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: false
    // },{
    //   id: 2, fullName:"Semen Shibaev", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: false
    // },{
    //   id: 3, fullName:"Peotr Markov", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: true
    // },{
    //   id: 4, fullName:"Evgeniy Tsopa", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: true
    // },{
    //   id: 5, fullName:"Ivan Ivanov", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: null
    // },{
    //   id: 6, fullName:"Stepan Stepanovich", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: false
    // },{
    //   id: 7, fullName:"Klim Sanich", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: null
    // }];

    return this.http.get<Humanoid[]>("api/main/get/all_entities");
  }

  getDescendants(): Humanoid[]{
    //TODO: запросом доставать всех родственников по заданному ID(добавить параметр)
    this.descendants = [{
      entityId: 3, fullName:"Peotr Markov", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: true
    },{
      entityId: 4, fullName:"Evgeniy Tsopa", sex:"Male", birthDate:"20.11.2001", deathDate:"20.11.2022",location:"[31.12;31.16]", isHuman: true
    }];
    return this.descendants;
  }

  getReplicantModel(id: number): ReplicantData{
    //TODO: запросом доставать модель реплеканта по id гуманойда
    return {id: 1, corporationName: "Штаб бегущих по лезвию в жопе мира", description: "Любит долбить себя в очелло", name: "Nexus-9"}
  }
}
