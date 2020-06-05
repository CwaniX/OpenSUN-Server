package pl.cwanix.opensun.utils.files;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import java.io.File;

@Slf4j
@Getter
@Setter
public class SUNArchive {

	private static final Marker MARKER = MarkerFactory.getMarker("SUN ARCHIVE");

	private File file;
	private String fileName;

	public boolean loadFile(String fileName) {
		this.file = new File(fileName);
		this.fileName = fileName;

		log.debug(MARKER, "Loaded archive file: {}", fileName);

		return true;
	}

	private void read() {

	}

	public SUNArchiveChunkInfo readChunk() {
		return null;
	}

	public void skipCurrentChunk() {
	}

	public String readName() {
		return null;
	}

	public int getVersion() {
		return 0;
	}
}
