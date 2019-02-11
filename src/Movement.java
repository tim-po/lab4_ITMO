public class Movement extends Action implements describable{
    private Place destination;
    private Person performer;

    public Movement(Place to, Person performer){
        super(" переместился из " + performer.getCurentInhabitance() + " в " + to, performer);
        this.destination = to;
        this.performer = performer;
    }

    @Override
    public void describe() {
        System.out.print(performer.toString());
        System.out.print(" ");
        System.out.print(this.toString());
    }

    @Override
    void hapen() throws VisitException {
        try {
            super.hapen();
            performer.change_inhabitance(destination);
        }catch (Exception ex){
            throw new VisitException("Somthing went wronge during movement:", this);
        }
    }
}
