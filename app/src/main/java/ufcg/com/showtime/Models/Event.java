package ufcg.com.showtime.Models;

import java.util.List;

/**
 * Created by franklin on 21/11/15.
 */
public class Event {

    private String nome;
    private String lugar;
    private List<Musico> musicos;
    private String banner;

    public Event (String nome, String lugar) {
        this.nome = nome;
        this.lugar = lugar;
    }

    public Event (String nome, String lugar, String banner) {
        this.nome = nome;
        this.lugar = lugar;
        this.banner = banner;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<Musico> getMusicos() {
        return musicos;
    }

    public void addMusico (Musico m) {
        musicos.add(m);
    }

    public String getBanner() {
        return this.banner;
    }

    public void addBanner(String banner) {
        this.banner = banner;
    }
}
