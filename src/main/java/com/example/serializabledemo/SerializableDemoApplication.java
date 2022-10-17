package com.example.serializabledemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

import java.io.*;

@SpringBootApplication
public class SerializableDemoApplication {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        User user1 = new User();
        user1.setName("binarylei");
        oos.writeObject(user1);
        byte[] bytes = baos.toByteArray();
        System.out.println(bytes.length);               // length=89

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        User user2 = (User) ois.readObject();
        if(user1.getName().equals(user2.getName())){
            System.out.println("true1");
        }// 反序列化后保存了 User.name 信息
        if(user1.equals(user2)){
            System.out.println("true2");
        }

        oos.close();
        ois.close();
    }

}
