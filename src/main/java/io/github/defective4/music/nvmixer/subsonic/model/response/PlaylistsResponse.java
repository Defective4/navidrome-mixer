package io.github.defective4.music.nvmixer.subsonic.model.response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.github.defective4.music.nvmixer.subsonic.model.Playlist;
import io.github.defective4.music.nvmixer.subsonic.model.SubsonicError;

public class PlaylistsResponse extends SubsonicResponse {
    public static record Playlists(@SerializedName("playlist") List<Playlist> playlists) {
    }

    private final Playlists playlists;

    public PlaylistsResponse(String status, String version, String type, String serverVersion, SubsonicError error,
            Playlists playlists) {
        super(status, version, type, serverVersion, error);
        this.playlists = playlists;
    }

    public Playlists getPlaylistContainer() {
        return playlists;
    }

}
