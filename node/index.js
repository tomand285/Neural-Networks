const math = require("mathjs");

let inputs = [1, 2, 3, 2.5]

let weights = [[0.2, 0.8, -0.5, 1.0],
                [0.5, -0.91, 0.26, -0.5],
                [-0.26, -0.27, 0.17, 0.87]]

let biases = [2, 3, 0.5]

let output = math.add(math.multiply(weights, inputs), biases);
console.log(output)