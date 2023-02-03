import { Coach } from './Coach';
import { CricketCoach } from "./CricketCoach";
import { GolfCoach } from './GolfCoach';

let myCoaches: Coach[] = [];
myCoaches.push(new CricketCoach());
myCoaches.push(new GolfCoach());

myCoaches.forEach(myCoach => {
    console.log(myCoach.getDailyWorkout());
});