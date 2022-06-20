import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Furniture} from "./model/Furniture";
import {CreateFurnitureRequest} from "./model/dto/CreateFurnitureRequest";
import {FurnitureIdNameDescriptionDto} from "./model/dto/FurnitureIdNameDescriptionDto";

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

  private apiFurnitureUrl: string = "http://localhost:8080/api/v1/furniture/"
  private apiCreateEmptyFurnitureUrl: string = this.apiFurnitureUrl + "create-empty"
  private apiGetFurnitureNameAndDescriptionDtosUrl: string = this.apiFurnitureUrl + "names-descriptions";


  constructor(private http: HttpClient) {
  }

  postCreateFurniture(request: CreateFurnitureRequest): Observable<Furniture> {
    return this.http.post<Furniture>(this.apiCreateEmptyFurnitureUrl, request);
  }

  getAllFurnitureNameAndDescription(): Observable<FurnitureIdNameDescriptionDto[]> {
    return this.http.get<FurnitureIdNameDescriptionDto[]>(this.apiGetFurnitureNameAndDescriptionDtosUrl);
  }

  removeFurnitureById(id: string): Observable<unknown>{
    return this.http.delete(this.apiFurnitureUrl + id);
  }

  getFurnitureById(id: string): Observable<Furniture> {
    return this.http.get<Furniture>(this.apiFurnitureUrl + id);
  }
}
