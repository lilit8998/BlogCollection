package blog.storage;

import blog.execption.PostNotFoundExecption;
import blog.model.Category;
import blog.model.Post;

public interface PostStorage {
    static void printPostsByCategory(Category category) {}

    void add(Post post);
    Post getPostByTitle(String title) throws PostNotFoundExecption;

    void searchPostsByKeyword(String keyword);

    void printAllPost();


}
