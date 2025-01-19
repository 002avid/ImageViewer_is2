package es.ulpgc.software;

import es.ulpgc.software.presenter.ImagePresenter;
import es.ulpgc.software.view.MainFrame;
import es.ulpgc.software.control.NextCommand;
import es.ulpgc.software.control.PreviousCommand;
import es.ulpgc.software.io.FileImageLoader;
import es.ulpgc.software.model.Image;

import java.io.File;

public class Main {
    public static void main(String[] args){
        MainFrame mainFrame = new MainFrame();
        ImagePresenter imagePresenter = new ImagePresenter(mainFrame.imageDisplay());
        imagePresenter.show(image());
        mainFrame.add("Next",new NextCommand(imagePresenter));
        mainFrame.add("Previous", new PreviousCommand(imagePresenter));
        mainFrame.setVisible(true);
    }

    private static Image image(){
        return new FileImageLoader(new File("C:/Users/usuario/OneDrive/Imágenes/Fotones")).load();
    }
}