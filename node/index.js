const math = require("mathjs");

let X = [[1, 2, 3, 2.5],
        [2.0, 5.0, -1.0, 2.0],
        [-1.5, 2.7, 3.3, -0.8]];

class Layer_Dense{
    constructor(n_inputs, n_neurons){
        this.weights = math.random([n_inputs,n_neurons]);
        this.biases = math.zeros([n_neurons]);
    }
    
    forward(inputs){
        this.output = math.add(math.multiply(inputs, this.weights), this.biases[0]);
    }
}

let layer1 = new Layer_Dense(4,5)
let layer2 = new Layer_Dense(5,2)

layer1.forward(X);
layer2.forward(layer1.output)

console.log(layer2.output)