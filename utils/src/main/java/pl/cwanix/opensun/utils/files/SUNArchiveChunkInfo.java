package pl.cwanix.opensun.utils.files;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SUNArchiveChunkInfo {

	public static final int CHUNK_INFO_SIZE = 6;

	private int id;
	private int size;
}
