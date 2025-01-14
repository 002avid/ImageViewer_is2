package es.ulpgc.software.control;

import es.ulpgc.software.view.ImagePresenter;

public class NextCommand implements Command{

    private final ImagePresenter imagePresenter;

    public NextCommand(ImagePresenter presenter){
        this.imagePresenter = presenter;
    }

    @Override
    public void execute(){
        imagePresenter.show(imagePresenter.image().next());
    }
}