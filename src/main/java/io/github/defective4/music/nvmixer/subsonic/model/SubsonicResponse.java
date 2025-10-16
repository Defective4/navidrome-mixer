package io.github.defective4.music.nvmixer.subsonic.model;

public class SubsonicResponse {
    private final SubsonicError error;
    private final String serverVersion;
    private final String status;
    private final String type;
    private final String version;

    public SubsonicResponse(String status, String version, String type, String serverVersion, SubsonicError error) {
        this.status = status;
        this.version = version;
        this.type = type;
        this.serverVersion = serverVersion;
        this.error = error;
    }

    public SubsonicError getError() {
        return error;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getVersion() {
        return version;
    }

    public boolean isError() {
        return error != null;
    }
}
