//javac main.java
//java main
import java.util.*;

public class main {
    public static void main(String args[]){
        List<Double> inputs = new ArrayList<Double>(Arrays.asList(1.0, 2.0, 3.0, 2.5));

        List<ArrayList<Double>> weights = new ArrayList<>(Arrays.asList(
            new ArrayList<Double>(Arrays.asList(0.2, 0.8, -0.5, 1.0)), 
            new ArrayList<Double>(Arrays.asList(0.5, -0.91, 0.26, -0.5)), 
            new ArrayList<Double>(Arrays.asList(-0.26, -0.27, 0.17, 0.87))));

        List<Double> biases = new ArrayList<Double>(Arrays.asList(2.0, 3.0, 0.5));

        List<Double> output = add(dot(weights, inputs), biases);

        System.out.println(output);
    }

    private static List<Double> dot(List<ArrayList<Double>> weights, List<Double> inputs){
        List<Double> result = new ArrayList<>();
        for(int i= 0; i<weights.size();i++){
            double node = 0;
            for(int j=0;j<weights.get(i).size();j++){
                node += weights.get(i).get(j)*inputs.get(j);
            }
            result.add(node);
        }
        return result;
    }

    private static List<Double> add(List<Double> dotProduct, List<Double> biases){
        List<Double> result = new ArrayList<>();
        for(int i= 0; i<dotProduct.size();i++){
            result.add(dotProduct.get(i)+biases.get(i));
        }
        return result;
    }
}