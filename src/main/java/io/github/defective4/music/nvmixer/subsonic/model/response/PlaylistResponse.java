package io.github.defective4.music.nvmixer.subsonic.model.response;

import io.github.defective4.music.nvmixer.subsonic.model.Playlist;
import io.github.defective4.music.nvmixer.subsonic.model.SubsonicError;

public class PlaylistResponse extends SubsonicResponse {
    private final Playlist playlist;

    public PlaylistResponse(String status, String version, String type, String serverVersion, SubsonicError error,
            Playlist playlist) {
        super(status, version, type, serverVersion, error);
        this.playlist = playlist;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

}
