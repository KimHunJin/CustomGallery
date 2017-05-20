package dxmnd.com.customgallery.items;

/**
 * Created by HunJin on 2017-05-19.
 */

public class ItemMainGalleryGrid {
    private int mTag;
    private String image;

    public ItemMainGalleryGrid(int mTag, String image) {
        this.mTag = mTag;
        this.image = image;
    }

    public int getmTag() {
        return mTag;
    }

    public String getImage() {
        return image;
    }
}
