import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.time.LocalDate;

public class SerializeDeserialize {

    /**
     * Сериализация и сохранение в бинарный файл
     */
    public void Serialize(String filename, ArrayList list) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            backupFile(filename);
            out.writeObject(list);
            out.close();
            fileOut.close();
            backupFile(filename);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Десериализация
     */
    public ArrayList Deserialize(String filename) {
        ArrayList<Object> list = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileIn);
            list = (ArrayList<Object>) objectInputStream.readObject();
            objectInputStream.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return list;
    }

    /**
     * Метод очистки данных
     */
    public void Clear(ArrayList list) {
        list.clear();
    }

    /**
     * Формирование имени для файла резервной копии
     */
    public String getNameBackupFile() {
        String timeBackup = String.valueOf(System.currentTimeMillis());
        timeBackup = "ReserveCopy_" + timeBackup + "_";
        return timeBackup;
    }

    /**
     * Резервное копирование
     */
    private void backupFile(String filename) throws IOException {
        String filename2 = getNameBackupFile();
        File file1 = new File(filename);
        File file2 = new File(filename2 + filename);
        FileChannel sourceChannel;
        FileChannel destChannel;
        sourceChannel = new FileInputStream(file1).getChannel();
        destChannel = new FileOutputStream(file2).getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

    }
}
