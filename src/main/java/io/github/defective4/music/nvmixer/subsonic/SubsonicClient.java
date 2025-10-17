package io.github.defective4.music.nvmixer.subsonic;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import io.github.defective4.music.nvmixer.crypto.TokenGenerator;
import io.github.defective4.music.nvmixer.subsonic.model.Playlist;
import io.github.defective4.music.nvmixer.subsonic.model.response.PlaylistResponse;
import io.github.defective4.music.nvmixer.subsonic.model.response.PlaylistsResponse;
import io.github.defective4.music.nvmixer.subsonic.model.response.SubsonicResponse;

public class SubsonicClient {

    private static final String API_VERSION = "1.16.1";

    private final String appName;
    private final String baseURL;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final String password;
    private final TokenGenerator tokenGenerator;
    private final String user;

    public SubsonicClient(String baseURL, String user, String password, String appName)
            throws NoSuchAlgorithmException {
        this.baseURL = baseURL;
        this.user = user;
        tokenGenerator = new TokenGenerator(16);
        this.password = password;
        this.appName = appName;
    }

    public PlaylistResponse getPlaylist(String id) throws IOException {
        return readObject("getPlaylist", PlaylistResponse.class, Map.of("id", id));
    }

    public PlaylistsResponse getPlaylists() throws IOException {
        return readObject("getPlaylists", PlaylistsResponse.class);
    }

    public Playlist populatePlaylist(Playlist playlist) throws IOException {
        PlaylistResponse resp = getPlaylist(playlist.getId());
        if (resp.isError()) throw new IOException(resp.getError().message());
        return resp.getPlaylist();
    }

    private URL constructURL(String path) throws IOException {
        return constructURL(path, Collections.emptyMap());
    }

    private URL constructURL(String path, Map<String, String> args) throws IOException {
        String salt = tokenGenerator.generateSalt();
        String token = tokenGenerator.generateHash(password, salt);

        StringBuilder extra = new StringBuilder();
        for (Entry<String, String> entry : args.entrySet()) {
            extra.append(String.format("&%s=%s", entry.getKey(), urlformat(entry.getValue())));
        }

        return URI.create(String.format("%s/rest/%s?u=%s&t=%s&s=%s&v=%s&c=%s&f=json%s", baseURL, path, urlformat(user),
                urlformat(token), urlformat(salt), urlformat(API_VERSION), urlformat(appName), extra.toString()))
                .toURL();
    }

    private JsonElement readJSON(String path) throws IOException {
        return readJSON(path, Map.of());
    }

    private JsonElement readJSON(String path, Map<String, String> params) throws IOException {
        try (Reader reader = new InputStreamReader(constructURL(path, params).openStream())) {
            return JsonParser.parseReader(reader).getAsJsonObject().get("subsonic-response");
        }
    }

    private <T extends SubsonicResponse> T readObject(String path, Class<T> type) throws IOException {
        return readObject(path, type, Map.of());
    }

    private <T extends SubsonicResponse> T readObject(String path, Class<T> type, Map<String, String> params)
            throws IOException {
        return gson.fromJson(readJSON(path, params), type);
    }

    private static String urlformat(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

}
