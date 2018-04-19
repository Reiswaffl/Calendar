

public class Unmarshaller_Test {
    public static void main(String[] args) {
        Interface i = new Interface();
        String s = i.GetPeriodInformation("180101","01").getContent();
        System.out.println(s);
    }
}

