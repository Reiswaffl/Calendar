public class DayObject{
    ONode root;
    DayObject(){
    }

    public void Add(String content){
        if(root == null)
        {
            root = new ONode(content);
        }else{
            root.Add(content);
        }
    }
    public String getContent(){
        if(root == null){
            return null;
        }
        return root.getContent();
    }
}
