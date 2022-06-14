import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Furniture} from "./furniture/Furniture";
import {CreateFurnitureRequest} from "./furniture/CreateFurnitureRequest";

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

  private apiFurnitureUrl: string = "http://localhost:8080/api/v1/furnitures"
  private apiCreateEmptyFurniture: string = this.apiFurnitureUrl + "/create-empty"

  constructor(private http: HttpClient) {
  }

  postCreateFurniture(request: CreateFurnitureRequest): Observable<Furniture> {
    return this.http.post<Furniture>(this.apiCreateEmptyFurniture, request);
  }

}
