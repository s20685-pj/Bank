package pl.pjatk.s20685bank.Model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Request {
    private Status status;
    private double newAmount;
}
