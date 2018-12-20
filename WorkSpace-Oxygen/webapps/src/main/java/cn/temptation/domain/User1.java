package cn.temptation.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * 博客：http://blog.csdn.net/qian_ch
 * @author Cody
 * @version V1.0 
 */

//域对象，实现序列化接口
public class User1 implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 7795674030518174692L;
	private String username;
    private MultipartFile image;

    public User1() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }   

}
