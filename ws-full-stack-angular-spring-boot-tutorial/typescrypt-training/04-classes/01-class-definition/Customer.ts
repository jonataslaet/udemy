class Customer {
    firstName: string;
    lastName: string;

    constructor(theFirst: string, theLast:string) {
        this.firstName = theFirst;
        this.lastName = theLast;
    }
}

let myCustomer = new Customer("Jonatas", "Laet");

console.log(myCustomer.firstName);
console.log(myCustomer.lastName);
