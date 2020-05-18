import java.util.*;

public class nnfs{
    private List<ArrayList<Double>> spiral_data_X;
    private List<Integer> spiral_data_y;
    
    public void spiral_data(int points, int classes){
        Random rd = new Random();
        List<ArrayList<Double>> X = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        
        for(int class_number = 0; class_number < classes; class_number++){
            double r = 0.0;
            double t = class_number*4.0;
            while(r <= 1 && t <= (class_number + 1) * 4){
                double random_t = t + (rd.nextDouble()*2-1) * 0.2;
                
                ArrayList<Double> ix = new ArrayList<>();
                ix.add(r * Math.sin(random_t * 2.5));
    			ix.add(r * Math.cos(random_t * 2.5));
    			X.add(ix);
    			y.add(class_number);
    
    			r += 1.0 / (points - 1); 
    			t += 4.0 / (points - 1);
            }
        }
        spiral_data_X = X;
        spiral_data_y = y;
    }
    
    public void spiral_data_nnfs(int points, int classes){
        //https://stackoverflow.com/questions/5711084/java-runtime-getruntime-getting-output-from-executing-a-command-line-program
        spiral_data(points, classes);
    }
    
    public List<ArrayList<Double>> getSpiral_data_X(){
            return spiral_data_X;
    }
    
    public List<Integer> getSpiral_data_y(){
            return spiral_data_y;
    }
}