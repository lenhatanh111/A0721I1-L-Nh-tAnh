package com.codegym.model;


import javax.persistence.*;

@Entity
@Table(name = "music_manager")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String music_type;
    private String link;


    public Music() {
    }

    public Music(int id, String name, String singer, String music_type, String link) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.music_type = music_type;
        this.link = link;
    }

    public Music(String name, String singer, String music_type, String link) {
        this.name = name;
        this.singer = singer;
        this.music_type = music_type;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getMusic_type() {
        return music_type;
    }

    public void setMusic_type(String music_type) {
        this.music_type = music_type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
