"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var Circle_1 = require("./Circle");
var Rectangle_1 = require("./Rectangle");
var myShapes = [];
var myCircle = new Circle_1.Circle(5, 10, 20);
var myRectangle = new Rectangle_1.Rectangle(0, 0, 3, 7);
myShapes.push(myCircle);
myShapes.push(myRectangle);
myShapes.forEach(function (myShape) {
    console.log(myShape.getInfo());
});
