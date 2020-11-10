import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {

    private static final String FILE_DANHBA = "danhba.csv";
    private static final String FILE_DANHBA2 = "listDanhBa.csv";


    public void write(List<DachBa> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(FILE_DANHBA));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<DachBa> read() {

        FileInputStream fis;
        try {
            fis = new FileInputStream(FILE_DANHBA);
            ObjectInputStream ois=new ObjectInputStream(fis);
            List<DachBa>list=(List<DachBa>) ois.readObject();
            if(list==null){
                list=new ArrayList<DachBa>();
            }
            return list;
        } catch (ClassNotFoundException | IOException e) {
            return null;
        }
    }

    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
