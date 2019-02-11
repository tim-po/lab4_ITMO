public class Place {
    private String naming;

    @Override
    public String toString() {
        return naming;
    }

    public Place(String withName){
        naming = withName;
    }
}
