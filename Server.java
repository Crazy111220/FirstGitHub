package com.kgc.pet.day21.homework.three;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {//接收
            ServerSocket server = new ServerSocket(111);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            FileOutputStream fos = new FileOutputStream("src/2.jpg");
            DataInputStream dos = new DataInputStream(is);

            int r;
            while((r = dos.read()) != -1){
                fos.write(r);
            }

            dos.close();
            fos.close();
            is.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
