import {Element} from "../../element/model/Element";

export interface Part {

  name: string;
  description: string
  elements: Set<Element>
  quantityPerConfiguration: number
}
