package io.github.defective4.music.nvmixer.subsonic.model.response;

import java.util.List;

import io.github.defective4.music.nvmixer.subsonic.model.Playlist;
import io.github.defective4.music.nvmixer.subsonic.model.SubsonicError;

public class PlaylistsResponse extends SubsonicResponse {
    public static class Playlists {
        private final List<Playlist> playlist;

        public Playlists(List<Playlist> playlist) {
            this.playlist = playlist;
        }

        public List<Playlist> getPlaylists() {
            return playlist;
        }
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
