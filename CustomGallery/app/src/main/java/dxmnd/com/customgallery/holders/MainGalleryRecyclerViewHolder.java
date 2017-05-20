package dxmnd.com.customgallery.holders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import dxmnd.com.customgallery.R;
import dxmnd.com.customgallery.items.ItemMainGalleryGrid;

/**
 * Created by HunJin on 2017-05-19.
 */

public class MainGalleryRecyclerViewHolder extends BaseViewHolder {

    private ImageView mImageGallery;
    private CheckBox mCheckBoxGallery;
    private View mView;

    public MainGalleryRecyclerViewHolder(View view) {
        super(view);
        this.mView = view;
        this.mImageGallery = (ImageView)view.findViewById(R.id.img_rcv_gallery);
        this.mCheckBoxGallery = (CheckBox)view.findViewById(R.id.ckbox_rcv_gallery);
    }

    @Override
    public void setDataOnView(int position, List<ItemMainGalleryGrid> items) {
        ItemMainGalleryGrid item = items.get(position);
        Glide.with(mView.getContext())
                .load(item.getImage())
                .override(150,150)
                .centerCrop()
                .into(mImageGallery);
    }
}
