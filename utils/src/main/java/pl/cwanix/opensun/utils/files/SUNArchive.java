package pl.cwanix.opensun.utils.files;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Getter
@Setter
@SuppressWarnings("checkstyle:MagicNumber")
public class SUNArchive implements AutoCloseable {

    private static final Marker MARKER = MarkerFactory.getMarker("SUN ARCHIVE");

    private File file;
    private String fileName;
    private InputStream inputStream;

    public boolean loadFile(final String fileName) {
        try {
            this.file = new File(fileName);
            this.fileName = fileName;
            this.inputStream = new FileInputStream(file);

            log.debug(MARKER, "Loaded archive file: {}", fileName);

            return true;
        } catch (FileNotFoundException e) {
            log.debug(MARKER, "Unable to load archive file: {}", fileName);

            return false;
        }
    }

    public byte[] read(final int size) {
        byte[] buffer = new byte[size];

        try {
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer;
    }

    private int read(final SUNArchiveChunkInfo chunkInfo) {
        try {
            byte[] chunkInfoContent = new byte[SUNArchiveChunkInfo.CHUNK_INFO_SIZE];
            int result = inputStream.read(chunkInfoContent);

            chunkInfo.setId(BytesUtils.byteArrayToShort(chunkInfoContent[0], chunkInfoContent[1]));
            chunkInfo.setSize(BytesUtils.byteArrayToInt(chunkInfoContent[2], chunkInfoContent[3], chunkInfoContent[4], chunkInfoContent[5]));

            return result;
        } catch (IOException e) {
            log.error(MARKER, "Unable to read stream data");

            return 0;
        }
    }

    public SUNArchiveChunkInfo readChunk() {
        SUNArchiveChunkInfo chunkInfo = new SUNArchiveChunkInfo();

        if (read(chunkInfo) <= 0) {
            chunkInfo.setId(0);
        }

        return chunkInfo;
    }

    public long skipCurrentChunk(final SUNArchiveChunkInfo chunkInfo) {
        try {
            return inputStream.skip(chunkInfo.getSize() - SUNArchiveChunkInfo.CHUNK_INFO_SIZE);
        } catch (IOException e) {
            log.error(MARKER, "Unable to skip chunk data");

            throw new RuntimeException("");

            //return 0;
        }
    }

    public String readName() {
        return null;
    }

    public int getVersion() {
        return 0;
    }

    @Override
    public void close() throws Exception {
        inputStream.close();
    }
}
