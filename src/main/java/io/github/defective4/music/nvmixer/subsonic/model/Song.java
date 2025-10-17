package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Duration;
import java.util.List;

public class Song {
    private final List<Artist> artists, albumArtists;
    private final int bitrate, samplingRate, channelCount;
    private final String diplayArtist, displayAlbumArtist;
    private final List<Genre> genres;
    private final String id, parent, title, album, artist, genre, coverArt, contentType, suffix, path, albumId,
            artistId, type, comment, sortName, mediaType;
    private final long size, duration;
    private final int year;

    public Song(String id, String parent, String title, String album, String artist, String genre, String coverArt,
            String contentType, String suffix, String path, String albumId, String artistId, String type,
            String comment, String sortName, String mediaType, List<Genre> genres, String diplayArtist,
            String displayAlbumArtist, List<Artist> artists, List<Artist> albumArtists, int year, long size,
            long duration, int bitrate, int samplingRate, int channelCount) {
        this.id = id;
        this.parent = parent;
        this.title = title;
        this.album = album;
        this.artist = artist;
        this.genre = genre;
        this.coverArt = coverArt;
        this.contentType = contentType;
        this.suffix = suffix;
        this.path = path;
        this.albumId = albumId;
        this.artistId = artistId;
        this.type = type;
        this.comment = comment;
        this.sortName = sortName;
        this.mediaType = mediaType;
        this.genres = List.copyOf(genres);
        this.diplayArtist = diplayArtist;
        this.displayAlbumArtist = displayAlbumArtist;
        this.artists = List.copyOf(artists);
        this.albumArtists = List.copyOf(albumArtists);
        this.year = year;
        this.size = size;
        this.duration = duration;
        this.bitrate = bitrate;
        this.samplingRate = samplingRate;
        this.channelCount = channelCount;
    }

    public String getAlbum() {
        return album;
    }

    public List<Artist> getAlbumArtists() {
        return albumArtists;
    }

    public String getAlbumId() {
        return albumId;
    }

    public String getArtist() {
        return artist;
    }

    public String getArtistId() {
        return artistId;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public int getBitrate() {
        return bitrate;
    }

    public int getChannelCount() {
        return channelCount;
    }

    public String getComment() {
        return comment;
    }

    public String getContentType() {
        return contentType;
    }

    public String getCoverArt() {
        return coverArt;
    }

    public String getDiplayArtist() {
        return diplayArtist;
    }

    public String getDisplayAlbumArtist() {
        return displayAlbumArtist;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(duration);
    }

    public String getGenre() {
        return genre;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getId() {
        return id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getParent() {
        return parent;
    }

    public String getPath() {
        return path;
    }

    public int getSamplingRate() {
        return samplingRate;
    }

    public long getSize() {
        return size;
    }

    public String getSortName() {
        return sortName;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

}
