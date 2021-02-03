package blog;

import blog.model.Category;
import blog.model.Post;
import blog.storage.PostStorage;
import blog.storage.impl.PostStorageFileImpl;

import java.util.Date;
import java.util.Scanner;

public class BlogMain implements Command {

    private static PostStorageFileImpl postStorage = new PostStorageFileImpl();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRun = true;

        while (isRun) {
            postStorage.printAllPost();
            printCommand();
            String commandStr = SCANNER.nextLine();
            int command;
            try {
                command = Integer.parseInt(commandStr);
            } catch (NumberFormatException e) {
                command = -1;
            }
            switch (command) {
                case Command.EXIT:
                    isRun = false;
                    break;
                case Command.ADD_POST:
                    addPost();
                    break;
                case Command.SEARCH_POST:
                    searchPost();
                    break;
                case Command.POST_BY_CATEGORY:
                    postByCatgory();
                    break;
                default:
                    System.out.println("Invalid command.Please try agai");

            }
        }
    }

    private static void postByCatgory() {
        for (Category value: Category.values()){
            System.out.println(value);
        }
        String categoryStr = SCANNER.nextLine();
        PostStorage.printPostsByCategory(Category.valueOf(categoryStr));

    }

    private static void searchPost() {
        System.out.println("Please input keyword");
        String keyword = SCANNER.nextLine();
        postStorage.searchPostsByKeyword(keyword);

    }

    private static void addPost() {
        System.out.println("Please enter title,text,category");
        System.out.println("Here is the category");
        for (Category value: Category.values()){
            System.out.println(value);
        }
        String postDataStr = SCANNER.nextLine();
        String[] postData = postDataStr.split(",");
        Post post = new Post(postData[0],postData[1],
                Category.valueOf(postData[2]), new Date());

        postStorage.add(post);
        System.out.println("Post was added ");

    }

    static void printCommand() {
        System.out.println("Please enter " + Command.EXIT + " for EXIT");
        System.out.println("Please enter " + Command.ADD_POST + " for ADD_POST");
        System.out.println("Please enter " + Command.SEARCH_POST + " for SEARCH_POST");
        System.out.println("Please enter " + Command.POST_BY_CATEGORY + " POST_BY_CATEGORY");

    }
}
