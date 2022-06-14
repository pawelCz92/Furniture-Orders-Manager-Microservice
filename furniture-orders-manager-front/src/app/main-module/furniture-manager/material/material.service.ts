import {Injectable} from '@angular/core';
import {Material} from "./model/Material";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {CreateMaterialRequest} from "./model/CreateMaterialRequest";

@Injectable({
  providedIn: 'root'
})
export class MaterialService {

  materialsUrl: string = "http://localhost:8080/api/v1/materials";

  constructor(private http: HttpClient) {
  }

  getAllMaterials(): Observable<Material[]> {
    return this.http.get<Material[]>(this.materialsUrl);
  }

  saveMaterial(request: CreateMaterialRequest): Observable<Material> {
    return this.http.post<Material>(this.materialsUrl, request);
  }

  removeMaterialById(id: string): Observable<any> {
    return this.http.delete<any>(this.materialsUrl + "/" + id);
  }
}
