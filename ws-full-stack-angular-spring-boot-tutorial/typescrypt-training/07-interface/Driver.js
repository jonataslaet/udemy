"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CricketCoach_1 = require("./CricketCoach");
var GolfCoach_1 = require("./GolfCoach");
var myCricketCoach = new CricketCoach_1.CricketCoach();
console.log(myCricketCoach.getDailyWorkout());
var myGolfCoach = new GolfCoach_1.GolfCoach();
console.log(myGolfCoach.getDailyWorkout());
