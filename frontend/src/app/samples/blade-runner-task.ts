import {BladeRunner} from './blade-runner';
import {Humanoid} from './humanoid';

export interface BladeRunnerTask {
  id: number,
  bladeRunner: BladeRunner,
  replicant: Humanoid,
  result: boolean
}
