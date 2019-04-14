import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDate;

public class Client {

	public static void main(String args[]) {

		try (Socket socket = new Socket(InetAddress.getLocalHost(), 8020);
				OutputStream o = socket.getOutputStream();
				ObjectOutput s = new ObjectOutputStream(o)) {
			// Serialize today's date to a output stream associated to the socket
			s.writeObject("Today's date");
			s.writeObject(LocalDate.now());
			s.flush();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("Error during serialization");
			System.exit(1);
		}
	}
}