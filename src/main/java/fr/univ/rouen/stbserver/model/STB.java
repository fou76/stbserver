package fr.univ.rouen.stbserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "STB")
public class STB implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    @Column(name = "nom_entite_client")
    private String nomEntiteClient;

    public STB() {
    }

    public STB(Integer id, String titre, String description, String date, String nomEntiteClient) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.date = date;
        this.nomEntiteClient = nomEntiteClient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNomEntiteClient() {
        return nomEntiteClient;
    }

    public void setNomEntiteClient(String nomEntiteClient) {
        this.nomEntiteClient = nomEntiteClient;
    }

    @Override
    public String toString() {
        return "SmallSTB{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", nomEntiteClient='" + nomEntiteClient + '\'' +
                '}';
    }
}
