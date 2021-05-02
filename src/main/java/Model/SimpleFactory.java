package Model;
    //wzorzec fabryki
public class SimpleFactory {

    public Field creatField(String type,int position) {
        if(type.equals("Normal")){
            return new NormalField(position,"Test",50,1,null);
        } else {
            return new SpecialField(position,"Test");
        }
    }
}
