import {Hq} from './hq';
import {Humanoid} from './humanoid';

export interface BladeRunner {
  br_id: number,
  entity: Humanoid,
  hq: Hq,
  position: string,
  position_description: string,
  status: boolean
}
