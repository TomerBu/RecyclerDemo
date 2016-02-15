package org.college.android.itomer.recyclerdemo;

/**
 * Created by iTomer on 14/02/2016.
 * Licence GPLv3
 * Copyright (C) 2016  iTomer
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class Note {
    private String title;
    private String content;
    private ImageState imageState;
    private int imageResId;

    //constructors:
    public Note(String title, String content, int imageResId) {
        setTitle(title);
        setContent(content);
        setImageResId(imageResId);
        setImageState(ImageState.DROID);
    }

    //enum to define a state of the image:
    public enum ImageState {
        DROID(0), NONE(1);
        private int value;

        //Constructor must exist
        private ImageState(int value) {
            this.value = value;
        }
    }

    /**
     Getters and Setters:
     */
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public ImageState getImageState() {
        return imageState;
    }
    public void setImageState(ImageState imageState) {
        this.imageState = imageState;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
    public int getImageResId() {
        return imageResId;
    }


    @Override
    public String toString() {
        return "Note{" +
                "content='" + content + '\'' +
                ", imageResId=" + imageResId +
                ", title='" + title + '\'' +
                '}';
    }
}
