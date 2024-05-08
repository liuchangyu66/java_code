/*空引用异常
如果我们的顺序表为空时，手动抛出空引用异常*/
public class NullException extends RuntimeException{
    public NullException(String message) {
        super(message);
    }
}
