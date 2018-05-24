package ReturnValues;


import java.util.ArrayList;

public class ReturnValue {
    ArrayList<String> content;
    ArrayList<String> period;
    public ReturnValue(){
        content = new ArrayList<>();
        period = new ArrayList<>();
    }
    public void AddContent(String content, String period){
        this.content.add(content);
        this.period.add(period);
    }
    public ArrayList<String> GetContent() {
        return content;
    }
    public ArrayList<String> GetPeriod(){
        return period;
    }
    public void SOUT(){
        for(String i : content){
            System.out.println(i);
        }
    }


}
