package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Instant;
import java.util.List;

public record Indexes(String ignoredArticles, List<Index> index, long lastModified) {

    public Instant getLastModified() {
        return Instant.ofEpochMilli(lastModified);
    }

}
