package es.ulpgc.software.view;

import es.ulpgc.software.model.Image;

public interface ImageDisplay{
    int getWidth();
    void paint(String id, int offset);
    void clear();
    void show(Image image);
    void on(Released released);
    void on(Shift shift);

    interface Released{
        Released Null = offset -> {};
        void offset(int offset);
    }

    interface Shift{
        Shift Null = offset -> {};
        void offset(int offset);
    }
}