public class Natural_event extends Event implements describable{

    @Override
    void hapen() {
        describe();
    }

    Natural_event(String name){
        super(name);
    }

    @Override
    public void describe() {
        System.out.print(this.toString() + "\n");
    }
}
