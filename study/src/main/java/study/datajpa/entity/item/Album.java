package study.datajpa.entity.item;

import lombok.Getter;
import lombok.Setter;
import study.datajpa.entity.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
@Getter
@Setter
public class Album extends Item {

    private String artist;
    private String etc;
}
