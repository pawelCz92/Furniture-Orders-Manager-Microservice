import {Element} from "../../element/model/Element";

export class Part {

  name: string = '';
  description: string = ''
  elements: Element[] = [];
  quantityPerConfiguration: number = 0
}
