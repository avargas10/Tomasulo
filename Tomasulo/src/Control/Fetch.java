package Control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import Modules.instCache;
import config.configValues;
public class Fetch {

	public Fetch() throws Throwable {
		
	}
	public void beginFetching() throws IOException {
		readInstructions(configValues.file);
	}
	private void readInstructions(String pFile) throws IOException {
		try {
			File file = new File(pFile);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int i = 0;
			while ((line = bufferedReader.readLine()) != null) {
				instCache.getInstance().setInstruction(i, splitter(line));
				i++;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private String[] splitter(String instr) {
		String[] parts = instr.split(",");
		return parts;
	}
	
	public String[] getInstruction(int pc) {
		return instCache.getInstance().getInstruction(pc);
	}

}
