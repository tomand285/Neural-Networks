import java.util.*;

public class math{
    public static List<ArrayList<Double>> dot(List<ArrayList<Double>> a, List<ArrayList<Double>> b){
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

    public static List<ArrayList<Double>> add(List<ArrayList<Double>> a, List<Double> b){
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