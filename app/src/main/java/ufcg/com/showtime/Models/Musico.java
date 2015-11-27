package ufcg.com.showtime.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by franklin on 21/11/15.
 */
public class Musico implements Parcelable{

    private String nome;
    private List<String> participantes;
    private String banner;
    private String estiloMusical;
    private int fama;
    private List<String> fotos;
    private List<String> musicas;
    private List<String> videos;

    public Musico (String nome, List<String> participantes, String estiloMusical) {
        this.nome = nome;
        this.participantes = participantes;
        this.estiloMusical = estiloMusical;
        this.banner = "";
        this.fama  = 0;
        this.fotos = new ArrayList<>();
        this.musicas = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    public Musico (String nome, List<String> participantes, String banner, String estiloMusical) {
        this.nome = nome;
        this.participantes = participantes;
        this.banner = banner;
        this.estiloMusical = estiloMusical;
        this.fama  = 0;
        this.fotos = new ArrayList<>();
        this.musicas = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    protected Musico(Parcel in) {
        nome = in.readString();
        participantes = in.createStringArrayList();
        banner = in.readString();
        estiloMusical = in.readString();
        fama = in.readInt();
        fotos = in.createStringArrayList();
        musicas = in.createStringArrayList();
        videos = in.createStringArrayList();
    }

    public static final Creator<Musico> CREATOR = new Creator<Musico>() {
        @Override
        public Musico createFromParcel(Parcel in) {
            return new Musico(in);
        }

        @Override
        public Musico[] newArray(int size) {
            return new Musico[size];
        }
    };

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

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public int getFama () {
        return fama;
    }

    public void addFama (int fama) {
        this.fama += fama;
    }

    public void subFama (int fama) {
        this.fama -= fama;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musico musico = (Musico) o;

        if (fama != musico.fama) return false;
        if (!nome.equals(musico.nome)) return false;
        if (!participantes.equals(musico.participantes)) return false;
        if (!banner.equals(musico.banner)) return false;
        if (!estiloMusical.equals(musico.estiloMusical)) return false;
        if (!fotos.equals(musico.fotos)) return false;
        if (!musicas.equals(musico.musicas)) return false;
        return videos.equals(musico.videos);

    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + participantes.hashCode();
        result = 31 * result + banner.hashCode();
        result = 31 * result + estiloMusical.hashCode();
        result = 31 * result + fama;
        result = 31 * result + fotos.hashCode();
        result = 31 * result + musicas.hashCode();
        result = 31 * result + videos.hashCode();
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeStringList(participantes);
        dest.writeString(banner);
        dest.writeString(estiloMusical);
        dest.writeInt(fama);
        dest.writeStringList(fotos);
        dest.writeStringList(musicas);
        dest.writeStringList(videos);
    }
}
