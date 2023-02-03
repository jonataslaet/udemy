"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var CricketCoach_1 = require("./CricketCoach");
var GolfCoach_1 = require("./GolfCoach");
var myCoaches = [];
myCoaches.push(new CricketCoach_1.CricketCoach());
myCoaches.push(new GolfCoach_1.GolfCoach());
myCoaches.forEach(function (myCoach) {
    console.log(myCoach.getDailyWorkout());
});
