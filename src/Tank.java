public class Tank extends Characters{
    Tank(int level, double speed, String name ,String CL) {
        super(level, speed, name ,CL);
    }

    void defence(Characters c){
        if(c.getElement("deff") < 1000){
//            c.deff += this.deff*0.2;
            c.assign_Element("deff",c.getElement("deff")+this.getElement("deff")*0.2);
            if(c.getElement("deff") >= 1000) c.assign_Element("deff",1000);
            System.out.println(this.getName_CL("name") + " deffence " + c.getName_CL("name")
            + " " + this.getElement("deff")*0.2);
        }else{
            System.out.println("Your deff is max.");
        }
    }
}
