import { Circle } from "./Circle";
import { Rectangle } from "./Rectangle";
import { Shape } from "./Shape";

let myShapes: Shape[] = [];

let myCircle = new Circle(5, 10, 20);
let myRectangle = new Rectangle(0, 0, 3, 7);
myShapes.push(myCircle);
myShapes.push(myRectangle);

myShapes.forEach(myShape => {
    console.log(myShape.getInfo());
});
