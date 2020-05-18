(async () => {
    const math = require("mathjs");
    //const spiral_data = require("./nnfs").datasets.spiral_data;
    let spiral_data = require("./nnfs").datasets.spiral_data_nnfs;
    
    let X = math.matrix([[1, 2, 3, 2.5],
            [2.0, 5.0, -1.0, 2.0],
            [-1.5, 2.7, 3.3, -0.8]]);
            
    X = (await spiral_data(100,3)).X;

    class Layer_Dense{
        constructor(n_inputs, n_neurons){
            this.weights = math.random([n_inputs,n_neurons]);
            this.biases = math.zeros([n_neurons]);
        }
        
        forward(inputs){
            this.output = math.add(math.multiply(inputs, this.weights), this.biases[0]);
        }
    }
    
    class Activation_ReLU{
        forward(inputs){
            this.output = math.matrix(inputs._data.map(layer => layer.map(i => i<0?0:i)));
        }
    }
    
    let layer1 = new Layer_Dense(2,5);
    let activation1 = new Activation_ReLU();
    
    layer1.forward(X);
    activation1.forward(layer1.output);
    
    console.log(activation1.output);
})();