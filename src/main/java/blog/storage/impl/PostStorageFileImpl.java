package blog.storage.impl;

import blog.execption.PostNotFoundExecption;
import blog.model.Post;
import blog.storage.PostStorage;
import blog.util.FileUtil;

import java.util.List;


public class PostStorageFileImpl implements PostStorage {

    private List<Post> postList;

    public PostStorageFileImpl(){
        postList = FileUtil.deserializePostMap();
    }

    @Override
    public void add(Post post) {
        postList.add(post);
        FileUtil.serializePostMap(postList);
    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFoundExecption {
        for (Post post : postList){
            if (post.getTitle() == title){
                System.out.println(post);
            }
        }
        return null;
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (Post post : postList){
            if (post.getTitle().equals(keyword)){
                System.out.println(post);
            }
        }
    }

    @Override
    public void printAllPost() {
        System.out.println(postList);

    }

}
