package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Duration;
import java.util.List;

public record Song(List<Artist> artists, List<Artist> albumArtists, int bitrate, int samplingRate, int channelCount,
        String diplayArtist, String displayAlbumArtist, List<Genre> genres, String id, String parent, String title,
        String album, String artist, String genre, String coverArt, String contentType, String suffix, String path,
        String albumId, String artistId, String type, String comment, String sortName, String mediaType, long size,
        long duration, int year) {

    public Duration getDuration() {
        return Duration.ofSeconds(duration);
    }

}
