package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Duration;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Playlist {
    private final long duration;
    private final List<Song> entry;
    private final String id, name, owner, coverArt;
    @SerializedName("public")
    private final boolean pub;
    private final int songCount;

    public Playlist(String id, String name, String owner, String coverArt, int songCount, long duration,
            List<Song> entry, boolean pub) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.coverArt = coverArt;
        this.songCount = songCount;
        this.duration = duration;
        this.entry = List.copyOf(entry);
        this.pub = pub;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(duration);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getSongCount() {
        return songCount;
    }

    public List<Song> getSongs() {
        return entry;
    }

    public boolean isPublic() {
        return pub;
    }

}
