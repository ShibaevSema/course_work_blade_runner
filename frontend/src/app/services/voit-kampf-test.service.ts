import { Injectable } from '@angular/core';
import {VoitKampfTestResult} from '../samples/voit-kampf-test-result';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VoitKampfTestService {
  voitCampfTests: VoitKampfTestResult[];

  constructor(private http: HttpClient) { }

  getAllVoitKampfTests(): Observable<any>{
    //TODO: запросом доставать все пройденные тесты
    return this.http.get("api/main/get/vk_tests");
  }

  getVoitKampfTests(entityId: number): Observable<any>{
    //TODO: Запросом достать все пройденные тесты репликантом по индексу id
    return this.http.post("api/main/post/vk_test", {id: entityId});
  }
}
