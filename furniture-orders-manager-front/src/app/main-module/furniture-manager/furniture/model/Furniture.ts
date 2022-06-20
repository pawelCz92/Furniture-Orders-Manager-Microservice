import {Configuration} from "./Configuration";
import {Element} from "../../element/model/Element";

export class Furniture {

  name: string = '';
  description: string = '';
  configurations: Configuration[] = [];
  elements: Element[] = [];
}
