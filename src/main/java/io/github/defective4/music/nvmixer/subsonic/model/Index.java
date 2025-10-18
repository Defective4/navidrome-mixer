package io.github.defective4.music.nvmixer.subsonic.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Index {
    @SerializedName("artist")
    private final List<Artist> artists;

    private final String name;

    public Index(String name, List<Artist> artists) {
        this.name = name;
        this.artists = List.copyOf(artists);
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public String getName() {
        return name;
    }

}
