package pl.cwanix.opensun.utils.files;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SUNFileReader extends Reader {

	private static final String COMMENT_PREFIX = "//";
	private static final String DELIMITER = "\\t";

	private BufferedReader in;
	private Map<String, Integer> header;
	private String[] currentLine;
	private int currentLineIndex;
	private int currentElementIndex;

	public SUNFileReader(String filePath) throws IOException {
		this.in = new BufferedReader(new FileReader(filePath));

		loadHeader();
	}

	public int read(char[] chars, int i, int i1) throws IOException {
		return in.read(chars, i, i1);
	}

	public boolean readLine() throws IOException {
		String line;
		boolean changed = false;

		while ((line = in.readLine()) != null) {
			++currentLineIndex;

			if (StringUtils.isNotBlank(line) || !line.startsWith(COMMENT_PREFIX)) {
				currentLine = line.split(DELIMITER);
				currentElementIndex = 0;
				changed = true;

				break;
			}
		}

		return changed;
	}

	public String readNextStringValue() {
		return currentLine[currentElementIndex++];
	}

	public int readNextIntValue() {
		return Integer.parseInt(currentLine[currentElementIndex++]);
	}

	public String readNextStringValue(String key) {
		return currentLine[header.get(key)];
	}

	public int readNextIntValue(String key) {
		return Integer.parseInt(currentLine[header.get(key)]);
	}

	public void close() throws IOException {
		in.close();
	}

	private void loadHeader() throws IOException {
		readLine();

		header = IntStream.range(0, currentLine.length).boxed().collect(Collectors.toMap(i -> currentLine[i], i -> i));
	}
}
