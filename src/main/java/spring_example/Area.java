/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spring_example;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aidyl
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "area", catalog = "spring", schema = "", uniqueConstraints = {
    @javax.persistence.UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @javax.persistence.NamedQuery(name = "Area.findById", query = "SELECT a FROM Area a WHERE a.id = :id"),
    @javax.persistence.NamedQuery(name = "Area.findByName", query = "SELECT a FROM Area a WHERE a.name = :name"),
    @javax.persistence.NamedQuery(name = "Area.findByDescription", query = "SELECT a FROM Area a WHERE a.description = :description")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "id", nullable = false)
    private Integer id;
    @javax.persistence.Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @javax.persistence.Column(name = "name", nullable = false, length = 500)
    private String name;
    @javax.persistence.Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5000)
    @javax.persistence.Column(name = "description", nullable = false, length = 5000)
    private String description;

    public Area() {
    }

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Area(String name, String description) {
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gradleproject1.Area[ id=" + id + " ]";
    }

}
