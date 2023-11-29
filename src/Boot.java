public  class Boot extends Accessories{
    Boot(int level, String name) {
        super(level, name);
    }

    void speedInc(Characters c){
        c.assign_Element("speed",c.getElement("speed")+50+(this.getLV()*0.5));
    }
}
