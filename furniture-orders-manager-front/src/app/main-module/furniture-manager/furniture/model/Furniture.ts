import {Configuration} from "./Configuration";
import {Element} from "../../element/model/Element";

export interface Furniture {

  name: string;
  description: string;
  configurations: Set<Configuration>;
  elements: Set<Element>;
}
