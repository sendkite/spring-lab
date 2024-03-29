package study.datajpa.entity.item;

import lombok.Getter;
import lombok.Setter;
import study.datajpa.entity.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter
@Setter
public class Movie extends Item {

    private String director;
    private String actor;
}
