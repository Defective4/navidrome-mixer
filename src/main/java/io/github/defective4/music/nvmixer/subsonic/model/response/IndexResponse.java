package io.github.defective4.music.nvmixer.subsonic.model.response;

import io.github.defective4.music.nvmixer.subsonic.model.Indexes;
import io.github.defective4.music.nvmixer.subsonic.model.SubsonicError;

public class IndexResponse extends SubsonicResponse {
    private final Indexes indexes;

    public IndexResponse(String status, String version, String type, String serverVersion, SubsonicError error,
            Indexes indexes) {
        super(status, version, type, serverVersion, error);
        this.indexes = indexes;
    }

    public Indexes getIndexes() {
        return indexes;
    }

}
