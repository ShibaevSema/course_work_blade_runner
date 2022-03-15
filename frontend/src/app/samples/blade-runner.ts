import {Hq} from './hq';
import {Humanoid} from './humanoid';

export interface BladeRunner {
  id: number,
  humanoid: Humanoid,
  hq: Hq,
  position: string,
  position_description: string,
  available: boolean
}
