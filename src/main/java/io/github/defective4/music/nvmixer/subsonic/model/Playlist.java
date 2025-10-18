package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Duration;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public record Playlist(long duration, @SerializedName("entry") List<Song> songs, String id, String name, String owner,
        String coverArt, @SerializedName("public") boolean pub, int songCount) {
    public Duration getDuration() {
        return Duration.ofSeconds(duration);
    }

}
