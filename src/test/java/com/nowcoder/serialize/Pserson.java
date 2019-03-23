package com.nowcoder.serialize;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;

import java.io.*;

/**
 * @author KnoWsea
 * @create 2019-02-28 23:08
 */
public class Pserson implements Serializable {
    private String name;
    private transient String tran;

    public Pserson(String name, String tran) {
        this.name = name;
        this.tran = tran;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTran() {
        return tran;
    }

    public void setTran(String tran) {
        this.tran = tran;
    }

    @Override
    public String toString() {
        return "Pserson{" +
                "name='" + name + '\'' +
                ", tran='" + tran + '\'' +
                '}';
    }
}
class seri{
    public static void main(String[] args) throws Exception {
        FileOutputStream op = new FileOutputStream("output.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(op);
        objectOutputStream.writeObject(new Pserson("knowsea", "transient object"));
        objectOutputStream.close();
    }

}
class seri2{
    public static void main (String[] args)throws Exception {
        FileInputStream is = new FileInputStream("output.txt");
        ObjectInputStream ois = new ObjectInputStream(is);
        Pserson o = (Pserson) ois.readObject();
        System.out.println(o);
        is.close();
    }
}
