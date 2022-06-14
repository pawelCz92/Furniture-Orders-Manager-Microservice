import {Part} from "./Part";

export interface Configuration {

  name: string;
  description: string;
  parts: Set<Part>;
}
