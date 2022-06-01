package me.parker.springjpapostgresql.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class ThisIsVeryLongNameTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "this_is_very_long_long_long_long_id", updatable = false, nullable = false)
    private Long id;
    private String data;

    public ThisIsVeryLongNameTable(Long id, String data) {
        this.id = id;
        this.data = data;
    }
}
