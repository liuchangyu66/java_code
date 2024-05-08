/*下标越界异常
当我们进行增删查改时，下标越界时，我们手动抛出一个下标越界异常*/
public class IndexException extends RuntimeException{
    public IndexException(String message) {
        super(message);
    }
}
