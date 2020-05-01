//javac main.java
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
            this.output = add(dot(inputs, this.weights), this.biases);
        }
        
        public List<ArrayList<Double>> getOutput(){
            return output;
        }
        
        private static List<ArrayList<Double>> dot(List<ArrayList<Double>> a, List<ArrayList<Double>> b){
            List<ArrayList<Double>> result = new ArrayList<>();
            for(int i= 0; i<a.size();i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j=0;j<b.get(0).size();j++){
                    Double val = 0.0;
                    for(int k=0;k<a.get(0).size();k++){
                        val += a.get(i).get(k) * b.get(k).get(j);
                    }
                    row.add(val);
                }
                result.add(row);
            }
            return result;
        }
    
        private static List<ArrayList<Double>> add(List<ArrayList<Double>> a, List<Double> b){
            List<ArrayList<Double>> result = new ArrayList<>();
            for(int i= 0; i<a.size();i++){
                ArrayList<Double> row = new ArrayList<>();
                for(int j=0;j<a.get(0).size();j++){
                    row.add(a.get(i).get(j) + b.get(j));
                }
                result.add(row);
            }
            return result;
        }
    }
    
    
    public static void main(String args[]){
        List<ArrayList<Double>> X = new ArrayList<>(Arrays.asList(
            new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 2.5)), 
            new ArrayList<Double>(Arrays.asList(2.0, 5.0, -1.0, 2.0)), 
            new ArrayList<Double>(Arrays.asList(-1.5, 2.7, 3.3, -0.8))));
        
        Layer_Dense layer1 = new Layer_Dense(4,5);
        Layer_Dense layer2 = new Layer_Dense(5,2);
        
        layer1.forward(X);
        layer2.forward(layer1.getOutput());

        System.out.println(layer2.getOutput());
    }
}