package io.github.defective4.music.nvmixer.subsonic.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public record Index(String name, @SerializedName("artist") List<Artist> artists) {

}
