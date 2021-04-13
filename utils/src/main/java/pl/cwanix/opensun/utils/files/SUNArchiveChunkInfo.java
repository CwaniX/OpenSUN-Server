package pl.cwanix.opensun.utils.files;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SUNArchiveChunkInfo {

    public static final int CHUNK_INFO_SIZE = 6;

    private int id;
    private long size;
}
