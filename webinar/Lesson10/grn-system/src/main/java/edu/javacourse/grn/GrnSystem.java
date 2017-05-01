package edu.javacourse.grn;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by antonsaburov on 27.03.17.
 */
public class GrnSystem
{
    public static void main(String[] args) {
        GrnSystem gm = new GrnSystem();
        gm.start();
    }

    private void start() {
        System.out.println("GrnSystem started");
        try {
            ServerSocket ses = new ServerSocket(7777);
            while(true) {
                Socket socket = ses.accept();

                StringBuilder sb = new StringBuilder();
                Reader br = new InputStreamReader(socket.getInputStream());
                char[] request = new char[6];
                int count = br.read(request);
                while(count != -1) {
                    sb.append(new String(request, 0, count));
                    if(sb.toString().endsWith("</person>")) {
                        break;
                    }
                    count = br.read(request);
                }
                System.out.println(sb.toString());

                OutputStream os = socket.getOutputStream();
                os.write("OK".getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
