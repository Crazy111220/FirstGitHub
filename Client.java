package com.kgc.pet.day21.homework.three;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {//发送图片
            Socket socket = new Socket("localhost", 111);
            OutputStream os = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            FileInputStream fis = new FileInputStream("src/1.jpg");
            int r = 0;
            while((r = fis.read()) != -1){
                os.write(r);
            }

            fis.close();
            dos.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
