package containers;

import java.util.ArrayList;
import java.util.Collections;

public class ContainerHistory {

    private ArrayList<Double> historyList;

    public ContainerHistory() {
        this.historyList = new ArrayList();
    }

    public void add(double situation){
        this.historyList.add(situation);
    }

    public void reset(){
        this.historyList.clear();
    }

    public double maxValue(){
        double maxValue = 0;
        if(this.historyList.isEmpty()){
            return maxValue;
        }else{
            for(double number: this.historyList){
                if(number > maxValue){
                    maxValue = number;
                }
            }
            return maxValue;
        }
    }

    public double minValue(){
        double minValue = 0;
        if(this.historyList.isEmpty()){
            return minValue;
        }else{
            minValue = maxValue();
            for(double number: this.historyList){
                if(number < minValue){
                    minValue = number;
                }
            }
            return minValue;
        }
    }

    public double average(){
        if(this.historyList.isEmpty()){
            return 0;
        }else{
            double sum = 0;
            for(double number:this.historyList){
                sum += number;
            }
            return sum / this.historyList.size() ;
        }
    }

    public double greatestFluctuation(){
        if(this.historyList.size() < 2){
            return 0;
        }else{

            double greatest = 0;
            for(int i = this.historyList.size() - 1; i > 0 ; i--){

                double test = Math.abs(this.historyList.get(i) - this.historyList.get(i-1));

                if( test > greatest){
                    greatest = test;
                }
            }
            return greatest;
        }
    }

    public double variance(){
        if(this.historyList.size() < 2){
            return 0;
        }else{
            double average = this.average();
            double variance = 0;

            for(double number: this.historyList){
                variance += Math.pow((number - average), 2);
            }
            return variance / (this.historyList.size() - 1);
        }
    }

    public String toString(){

        return "" + this.historyList;
    }
}
