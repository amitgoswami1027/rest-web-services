package com.amitgoswami.rest.webservices.JPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class JPAUser
{
    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message = "Name should have atleast two characters")
    private String name;

    @Past
    private Date DOB;

    @OneToMany(mappedBy = "")
    private List<JPAPost> posts;

    private JPAUser(){}

    public JPAUser(Integer id, String name, Date DOB) {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
    }

    /*public JPAUser(Integer id, @Size(min = 2, message = "Name should have atleast two characters") String name,
                   @Past Date DOB, List<JPAPost> posts)
    {
        this.id = id;
        this.name = name;
        this.DOB = DOB;
        this.posts = posts;
    }
*/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public List<JPAPost> getPosts()
    {
        return posts;
    }

    public void setPosts(List<JPAPost> posts)
    {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "AmitUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DOB=" + DOB +
                '}';
    }
}
