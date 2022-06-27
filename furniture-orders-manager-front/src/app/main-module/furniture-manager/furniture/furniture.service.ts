import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Furniture} from "./model/Furniture";
import {CreateFurnitureRequest} from "./model/dto/CreateFurnitureRequest";
import {FurnitureIdNameDescriptionDto} from "./model/dto/FurnitureIdNameDescriptionDto";
import {Element} from "../element/model/Element";
import {AddElementRequest} from "./model/dto/AddElementRequest";
import {RemoveElementRequest} from "./model/dto/RemoveElementRequest";

@Injectable({
  providedIn: 'root'
})
export class FurnitureService {

  private apiFurnitureUrl: string = "http://localhost:8080/api/v1/furniture/"
  private apiCreateEmptyFurnitureUrl: string = this.apiFurnitureUrl + "create-empty"
  private apiGetFurnitureNameAndDescriptionDtosUrl: string = this.apiFurnitureUrl + "names-descriptions";
  private apiAddElementUrl: string = this.apiFurnitureUrl + "add-element"
  private apiRemoveElementUrl: string = this.apiFurnitureUrl + "remove-element"


  constructor(private http: HttpClient) {
  }

  postCreateFurniture(request: CreateFurnitureRequest): Observable<Furniture> {
    return this.http.post<Furniture>(this.apiCreateEmptyFurnitureUrl, request);
  }

  getAllFurnitureNameAndDescription(): Observable<FurnitureIdNameDescriptionDto[]> {
    return this.http.get<FurnitureIdNameDescriptionDto[]>(this.apiGetFurnitureNameAndDescriptionDtosUrl);
  }

  removeFurnitureById(id: string): Observable<unknown> {
    return this.http.delete(this.apiFurnitureUrl + id);
  }

  getFurnitureByName(name: string): Observable<Furniture> {
    return this.http.get<Furniture>(this.apiFurnitureUrl + name);
  }

  addElementToFurniture(furnitureName: string, element: Element): Observable<any> {
    const addElementRequest: AddElementRequest = {
      furnitureName: furnitureName,
      materialName: element.materialName,
      length: element.length,
      height: element.height,
      thickness: element.thickness,
      suffix: element.suffix,
      description: element.description
    }
    return this.http.post(this.apiAddElementUrl, addElementRequest);
  }

  removeElementFromFurniture(furnitureName: string, elementId: string): Observable<any> {
    const removeElementRequest: RemoveElementRequest = {
      furnitureName: furnitureName,
      elementUuid: elementId
    }
    return this.http.post(this.apiRemoveElementUrl, removeElementRequest)
  }
}
