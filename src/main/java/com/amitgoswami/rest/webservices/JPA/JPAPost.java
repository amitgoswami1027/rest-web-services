package com.amitgoswami.rest.webservices.JPA;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
public class JPAPost
{
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private JPAUser user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public JPAUser getUser()
    {
        return user;
    }

    public void setUser(JPAUser user)
    {
        this.user = user;
    }

    @Override
    public String toString() {
        return "JPAPost{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
