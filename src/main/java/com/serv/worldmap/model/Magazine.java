package com.serv.worldmap.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "magazine")
public class Magazine extends AbstractBaseEntity {
    @NotBlank
    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    public Magazine() {
    }
    public Magazine(String text) {
        this(null, text);
    }
    public Magazine(Integer id, String text) {
        super(id);
        this.text = text;
    }

    public Magazine(Integer id) {
        super(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
