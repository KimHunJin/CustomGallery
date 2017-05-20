# CustomGallery
> custom gallery view

## using library
> 1. glide
> 2. tedpermission
> 3. recyclerview


## main source
```
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
```
