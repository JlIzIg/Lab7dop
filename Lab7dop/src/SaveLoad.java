import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class SaveLoad {
    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    ArrayList arrayList;

    public String getBytesOfObject() {
        byte[] bytes = getArrayList().toString().getBytes(StandardCharsets.UTF_8);
        char[] val = new char[2 * bytes.length];
        String hex = "0123456789abcdef";
        for (int i = 0; i < bytes.length; i++) {
            int b = bytes[i] & 0xff;
            val[2 * i] = hex.charAt(b >>> 4);
            val[2 * i + 1] = hex.charAt(b & 15);
        }
        return String.valueOf(val);
    }

    public void saveObject(File file) {
        String data = getBytesOfObject();
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data.getBytes());
            backupFile(file.getName());
            fos.close();
            backupFile(file.getName());
            System.out.println("Successfully written data to the file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String hex) {
        int l = hex.length();
        byte[] data = new byte[l / 2];
        for (int i = 0; i < l; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }

    public void Clear() {
        arrayList.clear();
    }

    public void load(File file) throws IOException {
        FileInputStream f = new FileInputStream(file.getName());
        byte[] array = f.readAllBytes();
        f.close();
        String str = new String(array, StandardCharsets.UTF_8);
        array = hexStringToByteArray(str);
        String st = new String(array, StandardCharsets.UTF_8);
        String[] strings = st.split(",");
        Workers workers = new Workers();
        setArrayList(workers.getFromString(strings));
    }

    public String getNameBackupFile() {
        String timeBackup = String.valueOf(System.currentTimeMillis());
        timeBackup = "ReserveCopy" + timeBackup + "_";
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
