import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;

public class Server {

	// Create the server socket and use its stream to receive serialized objects
	public static void main(String args[]) {

		Socket socket;
		String str;
		LocalDate date;

		try (ServerSocket server = new ServerSocket(8020)) {
			// This will wait for a connection to be made to this socket.
			socket = server.accept();
			InputStream o = socket.getInputStream();
			ObjectInput s = new ObjectInputStream(o);
			str = (String) s.readObject();
			date = (LocalDate) s.readObject();

			System.out.println(str);
			System.out.println(date);
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("Error during serialization");
			System.exit(1);
		}
	}
}