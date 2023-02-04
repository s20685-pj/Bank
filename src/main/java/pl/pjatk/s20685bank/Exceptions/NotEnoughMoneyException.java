package pl.pjatk.s20685bank.Exceptions;
import pl.pjatk.s20685bank.Model.Status;
public class NotEnoughMoneyException extends RuntimeException{

    public Status NotEnoughAmountOfMoney(Status message){
        message = Status.DECLINED;
        return message;
    }
}