package blog.util;

import blog.model.Post;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FileUtil {
    private static final String POST_MAP_PATH = "D:\\Blog\\src\\main\\java\\blog\\file\\post.txt";

    public static void serializePostMap(List<Post> postList){
        createFileIfNotExists(POST_MAP_PATH);
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(POST_MAP_PATH))){
            outputStream.writeObject(postList);
        } catch (IOException e) {
            System.out.println(POST_MAP_PATH + "does not exists/ or empty");
        }
    }

    public static List<Post> deserializePostMap(){
        createFileIfNotExists(POST_MAP_PATH);
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(POST_MAP_PATH))) {
            return (List<Post>) inputStream.readObject();
        }catch (IOException |ClassNotFoundException  e) {
            System.out.println(POST_MAP_PATH + " " + "does not exists/or empty");
            return new LinkedList<>();
        }
    }

    private static void createFileIfNotExists(String path){
        File file = new File(path);
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(path + "file can not be created");
            }
        }
    }
}
