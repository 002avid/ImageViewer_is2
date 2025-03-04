package es.ulpgc.software.control;

import es.ulpgc.software.presenter.ImagePresenter;

public class PreviousCommand implements Command{

    private final ImagePresenter imagePresenter;

    public PreviousCommand(ImagePresenter presenter){
        this.imagePresenter = presenter;
    }

    @Override
    public void execute(){
        imagePresenter.show(imagePresenter.image().prev());
    }
}