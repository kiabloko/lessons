package com.domain.lesson14.io.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDateTime;

public class LaunchStatisticExternalizable implements Externalizable {
    //по умолчанию не сериализует свойства. нужно описывать самим,что надо сериализовывать
    private int launchCount;
    private LocalDateTime lastLaunch;
    private String user;
    private static final long serialVersionUID = 1L; //версия для сериализации
    private static final int VERSION =5; //версия наша личная
    public boolean isFirstLaunch(){
        return launchCount == 0 && lastLaunch == null;

    }
    public  void update(){
        launchCount++;
        lastLaunch = LocalDateTime.now();
        user = System.getProperty("user.name");

    }
    //здесь описываем что и как сериализуем
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(VERSION);
        out.writeInt(launchCount);
        out.writeObject(lastLaunch);
        out.writeUTF(user);
    }
    //здесь описываем обратный процесс
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        int version = in.readInt();
        if (version > VERSION) throw new IOException("Версия не поддерживается");
        launchCount = in.readInt();
        lastLaunch = (LocalDateTime) in.readObject();
        if (version > 0){
            user = in.readUTF();
        }
    }

    @Override
    public String toString() {
        return "LaunchStatisticExternalizable{" +
                "launchCount=" + launchCount +
                ", lastLaunch=" + lastLaunch +
                ", user='" + user + '\'' +
                '}';
    }
}
