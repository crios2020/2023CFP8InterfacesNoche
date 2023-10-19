import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        String mensaje="";
        try (ServerSocket ss=new ServerSocket(8000)){
            while(true){
                System.out.println("Esperando conexión ......");
                try (
                        Socket so=ss.accept();
                        OutputStream out=so.getOutputStream();
                    ) {
                    mensaje=so.getInetAddress().getHostAddress();
                    mensaje=    "HTTP/1.1 200 OK\n"+
                        "Content-Type: text/plain\n"+
                        "Content-Length: "+mensaje.length()+"\n\n"
                        +mensaje;
                    out.write(mensaje.getBytes());
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        } catch (Exception e) {
            System.out.println();
        }
    }
}