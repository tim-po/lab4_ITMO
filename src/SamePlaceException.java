public class SamePlaceException extends Exception{
    private Place place;
    public Place getPlace(){return place;}
    public SamePlaceException(String message, Place place){
        super(message);
        this.place=place;
    }
}
