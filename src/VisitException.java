public class VisitException extends RuntimeException{
    private Movement visitMove;
    public Movement getVisitMove() {
        return visitMove;
    }
    public VisitException(String message, Movement visitMove){
        super(message);
        this.visitMove=visitMove;
    }
}
