public class ONode {
    PeriodObject period;
    ONode next;
    ONode(String content){
        period = new PeriodObject(content);
        this.next = null;

    }
    public void Add(String content){
        if(next == null){
            next = new ONode(content);
        }
        else{
            next.Add(content);
        }
    }
    public String getContent(){
        return period.getContent() + " / " + next.getContent();
    }
}
