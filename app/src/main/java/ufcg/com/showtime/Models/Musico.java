package ufcg.com.showtime.Models;

import java.util.List;

/**
 * Created by franklin on 21/11/15.
 */
public class Musico {

    private String nome;
    private List<String> participantes;
    private String banner;
    private List<String> fotos;
    private List<String> musicas;
    private List<String> videos;

    public Musico (String nome, List<String> participantes) {
        this.nome = nome;
        this.participantes = participantes;
    }

    public Musico (String nome, List<String> participantes, String banner) {
        this.nome = nome;
        this.participantes = participantes;
        this.banner = banner;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void removerParticipante(String participante) {
        participantes.remove(participante);
    }

    public void addParticipante(String participante) {
        participantes.add(participante);
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public List<String> getFotos() {
        return fotos;
    }

    public void addFotos(String foto) {
        fotos.add(foto);
    }

    public void removerFotos(String foto) {
        fotos.remove(foto);
    }

    public List<String> getMusicas() {
        return musicas;
    }

    public void addMusica(String musica) {
        musicas.add(musica);
    }

    public void removerMusica(String musica) {
        musicas.remove(musica);
    }

    public List<String> getVideos() {
        return videos;
    }

    public void addVideo(String video) {
        videos.add(video);
    }

    public void removerVideo(String video) {
        videos.remove(video);
    }
}
