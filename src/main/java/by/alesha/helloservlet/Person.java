package by.alesha.helloservlet;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
    private int age;
    private String name;
    private String login;
    private String password;
}
