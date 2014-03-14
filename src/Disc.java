import java.io.File;


public class Disc {

	public static void main(String[] args) {
		 
        File directory = new File(".");
 
        long totalSpace = directory.getTotalSpace();
        long freeSpace = directory.getFreeSpace();
        long usableSpace = directory.getUsableSpace();
 
        System.out.println("# Disk space information for the current filesystem #");
        System.out.println("Total space:\t" + convertToString(totalSpace));
        System.out.println("Free space:\t" + convertToString(freeSpace));
        System.out.println("Usable space:\t" + convertToString(usableSpace));
    }
 
    private static String convertToString(long bytes) {
 
        String[] postfixes = { " B", " KB", " MB", " GB", " TB", " PB" };
 
        int i = 0;
        long value = bytes;
 
        while (value > 1024L && i < postfixes.length) {
            value = value / 1024L;
 
            if (i + 1 == postfixes.length) {
                break;
            }
 
            i++;
        }
 
        return value + postfixes[i];
    }
}
