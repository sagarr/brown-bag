package demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class BrownBag {

    @Id
    @GeneratedValue
    private Integer id;
    private final String speaker;
    private final String topic;

}
