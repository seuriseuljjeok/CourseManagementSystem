package valueObject;

import java.io.Serializable;
import java.util.Scanner;

public class VIndex implements Serializable{
    private String id;
    private String name;
    private String fileName;
    public String getId() {return id;}
    public String getName() {return name;}
    public String getFileName() {return fileName;}
    public void setFileName(String fileName) {this.fileName = fileName;}

    public void read(Scanner scanner) {
        this.id = scanner.next();
        this.name = scanner.next();
        this.fileName = scanner.next();
    }
    public String getString(){
        String retVal = this.id + " " + this.name + " " + this.fileName;
        return retVal + "\n";
    }
}
