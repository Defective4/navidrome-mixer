package io.github.defective4.music.nvmixer.audio;

import java.io.File;
import java.io.IOException;

public class FFMpeg {
    private FFMpeg() {
    }

    public static void applyCrossfade(File output, long duration, File... inputs)
            throws IOException, InterruptedException {
        if (inputs.length < 2) return;
        String[] inputOpts = new String[inputs.length * 2];
        for (int i = 0; i < inputs.length; i++) {
            inputOpts[i * 2] = "-i";
            inputOpts[i * 2 + 1] = inputs[i].getAbsolutePath();
        }

        StringBuilder filterBuilder = new StringBuilder(String.format("[0][1]acrossfade=d=%sms[a1]", duration));

        for (int i = 2; i < inputs.length; i++) {
            filterBuilder.append(";");
            filterBuilder.append(String.format("[a" + (i - 1) + "][%s]acrossfade=d=%sms%s", i, duration,
                    i < inputs.length - 1 ? "[a" + i + "]" : ""));
        }

        String[] ffOpts = new String[] { "-y", "-filter_complex:a", filterBuilder.toString(), "-ab", "320k",
                output.getAbsolutePath() };

        String[] cmdline = new String[inputOpts.length + ffOpts.length + 1];
        cmdline[0] = "ffmpeg";
        System.arraycopy(inputOpts, 0, cmdline, 1, inputOpts.length);
        System.arraycopy(ffOpts, 0, cmdline, inputOpts.length + 1, ffOpts.length);
        runFFMpeg(cmdline);
    }

    public static void removeSilence(File source, File target, int thresholdDb)
            throws IOException, InterruptedException {
        runFFMpeg("ffmpeg", "-y", "-i", source.getAbsolutePath(), "-filter:a", String.format(
                "silenceremove=start_periods=1:start_threshold=%sdB,areverse,silenceremove=start_periods=1:start_threshold=%sdB,areverse",
                thresholdDb, thresholdDb), "-ab", "320k", target.getAbsolutePath());
    }

    private static void runFFMpeg(String... args) throws IOException, InterruptedException {
        if (new ProcessBuilder(args).start().waitFor() != 0) throw new IOException("ffmpeg failed");
    }
}
