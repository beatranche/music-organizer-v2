import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    public void listAllFiles(){
        int index = 0;
        while (index < files.size()){
            String filename = files.get(index);
            System.out.println(index + ". " + filename);
            index ++;
        }

    }

    public void listMatching(String searchString){
        int cont = 0;
        for (String filename : files){
            if (filename.contains(searchString)){
                cont++;
                System.out.println(filename);
            } 
        }
        if (cont == 0){
            System.out.println("Error. No hay canciones con el texto seleccionado");
        }
    }  

    public void playSampleArtist(String artist){
        ArrayList<String> sample = new ArrayList<>();
        for (String filename : files){
            if (filename.contains(artist)){
                sample.add(filename);
            }
        }
        for (String canciones : sample){
            player.playSample(canciones);
        }
    }

    /**
     * Localiza el �ndice del primer archivo que se corresponde con
     * la cadena de b�squeda indicada .
     * @param searchString La cadena que hay que buscar.
     * @return El �ndice de la primera aparici�n o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString){
        int index = 0;
        boolean searching = true;
        int aDevolver = 0;
        while (index < files.size() && searching){
            String filename = files.get(index);
            if (filename.contains(searchString)){
                aDevolver = index;
                searching = false;
            }
            index ++;
        }
        return aDevolver;
    }

}

