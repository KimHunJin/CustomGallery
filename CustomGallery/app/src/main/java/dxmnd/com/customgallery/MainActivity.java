package dxmnd.com.customgallery;

import android.Manifest;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;

import dxmnd.com.customgallery.adapters.MainGalleryRecyclerViewAdapter;
import dxmnd.com.customgallery.items.ItemMainGalleryGrid;

public class MainActivity extends AppCompatActivity {

    private int count;
    private Bitmap[] thumbNails;
    private boolean[] thumbNailsSelection;
    private String[] arrPath;
    private RecyclerView recyclerView;
    private MainGalleryRecyclerViewAdapter mainGalleryRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new TedPermission(this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .check();



    }

    PermissionListener permissionlistener = new PermissionListener() {
        @Override
        public void onPermissionGranted() {
            Toast.makeText(MainActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            final String[] colums = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
            final String orderBy = MediaStore.Images.Media._ID;

            mainGalleryRecyclerViewAdapter = new MainGalleryRecyclerViewAdapter(getApplicationContext());

            Cursor imageCursor = managedQuery(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, colums, null, null, orderBy
            );
            int imageColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media._ID);
            count = imageCursor.getCount();
            thumbNails = new Bitmap[count];
            arrPath = new String[count];
            thumbNailsSelection = new boolean[count];

            for(int i=0;i<count;i++) {
                imageCursor.moveToPosition(i);
                int id = imageCursor.getInt(imageColumnIndex);
                int dataColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA);
                thumbNails[i] = MediaStore.Images.Thumbnails.getThumbnail(
                        getApplicationContext().getContentResolver(),
                        id,
                        MediaStore.Images.Thumbnails.MICRO_KIND,
                        null
                );
                arrPath[i] = imageCursor.getString(dataColumnIndex);
                mainGalleryRecyclerViewAdapter.addData(new ItemMainGalleryGrid(i,arrPath[i]));
            }

            recyclerView = (RecyclerView)findViewById(R.id.rcv_gallery);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),4));
            recyclerView.setAdapter(mainGalleryRecyclerViewAdapter);

        }

        @Override
        public void onPermissionDenied(ArrayList<String> deniedPermissions) {
            Toast.makeText(MainActivity.this, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
        }
    };
}
