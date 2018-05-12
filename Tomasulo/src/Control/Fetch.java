package Control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import Modules.instCache;
public class Fetch {

	public Fetch() {
		// TODO Auto-generated constructor stub
	}
	
	private void readInstructions(String pFile) throws IOException {
        RandomAccessFile file = new RandomAccessFile("../assembly/program.txt", "r");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
        channel.read(buffer);
        buffer.flip();//Restore buffer to position 0 to read it
        for (int i = 0; i < channel.size(); i++) {
            System.out.print((char) buffer.get());
           // instCache.getInstance().setInstruction(i,splitter(buffer.get()) );
              
        }
        channel.close();
        file.close();

	}
	
	private String[] splitter(String instr) {
		String[] parts = instr.split(",");
		return parts;
	}

}
