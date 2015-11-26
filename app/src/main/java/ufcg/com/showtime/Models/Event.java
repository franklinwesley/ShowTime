package ufcg.com.showtime.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franklin on 21/11/15.
 */
public class Event {

    private String nome;
    private String data;
    private String hora;
    private String lugar;
    private List<Musico> musicos;
    private String banner;

    public Event (String nome, String data, String hora, String lugar) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.lugar = lugar;
        this.banner = "";
        this.musicos = new ArrayList<>();
    }

    public Event (String nome, String data, String hora, String lugar, String banner) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.lugar = lugar;
        this.banner = banner;
        this.musicos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setData(String data) {
        this.data = data;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (!nome.equals(event.nome)) return false;
        if (!data.equals(event.data)) return false;
        if (!hora.equals(event.hora)) return false;
        if (!lugar.equals(event.lugar)) return false;
        if (!musicos.equals(event.musicos)) return false;
        return banner.equals(event.banner);

    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + data.hashCode();
        result = 31 * result + hora.hashCode();
        result = 31 * result + lugar.hashCode();
        result = 31 * result + musicos.hashCode();
        result = 31 * result + banner.hashCode();
        return result;
    }
}