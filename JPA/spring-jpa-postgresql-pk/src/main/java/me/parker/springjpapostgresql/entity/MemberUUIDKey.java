package me.parker.springjpapostgresql.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
public class MemberUUIDKey implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private String name;
    private String email;

    public MemberUUIDKey(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
