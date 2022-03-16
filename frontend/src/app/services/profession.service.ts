import { Injectable } from '@angular/core';
import {Profession} from '../samples/profession';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProfessionService {
  constructor(private http: HttpClient) { }

  getProfession(entityId: number): Observable<any>{
    //TODO: по запросу получать профессию по id гуманойда
    const body = {id: entityId};
    console.log(body)
    return this.http.post<Profession>("api/main/post/entity_prof", body);
  }
}
