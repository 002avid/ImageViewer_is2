package es.ulpgc.software.io;

import es.ulpgc.software.model.Image;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Set;

public class FileImageLoader implements ImageLoader{
    private final File[] files;

    public FileImageLoader(File folder){ this.files = folder.listFiles(isImage());}

    private final Set<String> extensions =  Set.of("jpg", "png","jpeg");
    private FilenameFilter isImage() {
        return ((dir, name) -> extensions.stream().anyMatch(name::endsWith));
    }

    @Override
    public Image load(){
        return ImageAt(0);
    }

    private Image ImageAt(int i){
        return new Image() {
            @Override
            public String id() {
                return files[i].getAbsolutePath();
            }

            @Override
            public Image next(){
                return ImageAt((i+1)% files.length);
            }

            @Override
            public Image prev(){
                return ImageAt((i-1+ files.length)% files.length);
            }
        };
    }
}