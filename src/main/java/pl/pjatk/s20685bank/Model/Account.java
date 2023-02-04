package pl.pjatk.s20685bank.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.With;

@With
@Data
@AllArgsConstructor
public class Account {

    private Long id;
    private String name;
    private Long amount;
}
