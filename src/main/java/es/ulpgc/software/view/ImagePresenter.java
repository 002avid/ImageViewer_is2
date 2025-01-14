package es.ulpgc.software.view;

import es.ulpgc.software.model.Image;

import static es.ulpgc.software.view.ImageDisplay.*;

public class ImagePresenter{
    private final ImageDisplay display;
    private Image image;

    public ImagePresenter(ImageDisplay imageDisplay){
        this.display = imageDisplay;
        this.display.on((Shift) this::shift);
        this.display.on((Released) this::released);
    }

    private void repaint(){
        this.display.clear();
        this.display.paint(image.id(), 0);
    }

    private void shift(int offset){
        display.clear();
        display.paint(image.id(), offset);
        if (offset > 0){
            display.paint(image.prev().id(), offset - display.getWidth());
        }else{
            display.paint(image.next().id(), display.getWidth() + offset);
        }
    }

    private void released(int offset){
        if (Math.abs(offset) >= display.getWidth() / 2){
            image = offset > 0 ? image.prev():image.next();
            display.show(image);
        }
        repaint();
    }

    public void show(Image image){
        this.image = image;
        display.show(this.image);
        repaint();
    }

    public Image image(){
        return image;
    }
}