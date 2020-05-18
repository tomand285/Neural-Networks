//javac *.java
//java main
import java.util.*;

public class main {
    private static class Layer_Dense{
        public List<ArrayList<Double>> weights;
        public List<Double> biases;
        private List<ArrayList<Double>> output;
        
        Layer_Dense(int n_inputs, int n_neurons){
            Random rd = new Random();
            
            this.weights = new ArrayList<>();
            for(int i = 0; i < n_inputs; i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j = 0; j < n_neurons; j++){
                    row.add(rd.nextDouble());
                }
                this.weights.add(row);
            }
            
            this.biases = new ArrayList<>();
            for(int k = 0; k < n_neurons; k++){
                this.biases.add(0.0);
            }
        }
        
        public void forward(List<ArrayList<Double>> inputs){
            this.output = math.add(math.dot(inputs, this.weights), this.biases);
        }
        
        public List<ArrayList<Double>> getOutput(){
            return output;
        }
    }
    
    private static class Activation_ReLU{
        private List<ArrayList<Double>> output;
        
        public void forward(List<ArrayList<Double>> inputs){
            List<ArrayList<Double>> result = new ArrayList<>();
            for(int i= 0; i<inputs.size();i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j=0;j<inputs.get(0).size();j++){
                    row.add(inputs.get(i).get(j)<0?0:inputs.get(i).get(j));
                }
                result.add(row);
            }
            this.output = result;
        }
        
        public List<ArrayList<Double>> getOutput(){
            return output;
        }
    }
    
    
    public static void main(String args[]){
        List<ArrayList<Double>> X = new ArrayList<>(Arrays.asList(
            new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 2.5)), 
            new ArrayList<Double>(Arrays.asList(2.0, 5.0, -1.0, 2.0)), 
            new ArrayList<Double>(Arrays.asList(-1.5, 2.7, 3.3, -0.8))));
            
        nnfs NNFS = new nnfs();
        NNFS.spiral_data(100,3);
        
        X = NNFS.getSpiral_data_X();
        
        Layer_Dense layer1 = new Layer_Dense(2,5);
        Activation_ReLU activation1 = new Activation_ReLU();

        layer1.forward(X);
        System.out.println(layer1.getOutput());
        activation1.forward(layer1.getOutput());

        System.out.println(activation1.getOutput());
    }
}