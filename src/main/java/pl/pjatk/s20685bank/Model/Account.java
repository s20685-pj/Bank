package pl.pjatk.s20685bank.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@Data
@AllArgsConstructor
public class Account {

    private long id;
    private String name;
    private double amount;
}
