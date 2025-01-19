package es.ulpgc.software.viewport;

public class ViewPort {
    private final Dimension containerSize;
    private Dimension imageSize;

    public ViewPort(Dimension containerSize) {
        this.containerSize = containerSize;
    }

    private int scaleWidth(double scale) {
        return (int) (imageSize.width() * scale);
    }

    private double calculateScaleY() {
        return (double) containerSize.height() / imageSize.height();
    }

    private int scaleHeight(double scale) {
        return (int) (imageSize.height() * scale);
    }

    private double calculateScaleX() {
        return (double) containerSize.width() / imageSize.width();
    }

    private double calculateScale() {
        return Math.min(calculateScaleX(), calculateScaleY());
    }

    public Dimension resize(Dimension imageSize) {
        this.imageSize = imageSize;

        double scale = calculateScale();
        return calculateNewSize(scale);
    }

    private Dimension calculateNewSize(double scale) {
        int newWidth = scaleWidth(scale);
        int newHeight = scaleHeight(scale);
        return new Dimension(newWidth, newHeight);
    }
}