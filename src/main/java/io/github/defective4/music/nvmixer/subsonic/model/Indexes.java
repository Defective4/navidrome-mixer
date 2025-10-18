package io.github.defective4.music.nvmixer.subsonic.model;

import java.time.Instant;
import java.util.List;

public class Indexes {
    private final String ignoredArticles;
    private final List<Index> index;
    private final long lastModified;

    public Indexes(List<Index> index, long lastModified, String ignoredArticles) {
        this.index = List.copyOf(index);
        this.lastModified = lastModified;
        this.ignoredArticles = ignoredArticles;
    }

    public String getIgnoredArticles() {
        return ignoredArticles;
    }

    public List<Index> getIndex() {
        return index;
    }

    public Instant getLastModified() {
        return Instant.ofEpochMilli(lastModified);
    }

}
