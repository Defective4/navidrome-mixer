package io.github.defective4.music.nvmixer.subsonic.model;

public class Artist {
    private final String id, name;

    public Artist(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
